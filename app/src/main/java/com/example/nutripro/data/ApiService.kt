package com.example.nutripro.ui.components

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

object ApiService {
    suspend fun fetchRandomJoke(): Joke? {
        return withContext(Dispatchers.IO) {
            try {
                val url = URL("https://official-joke-api.appspot.com/random_joke")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val response = connection.inputStream.bufferedReader().use { it.readText() }
                    val json = JSONObject(response)
                    Joke(
                        setup = json.getString("setup"),
                        punchline = json.getString("punchline")
                    )
                } else {
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}

data class Joke(val setup: String, val punchline: String)
