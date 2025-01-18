package com.example.nutripro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.nutripro.navigation.AppNavHost
import com.example.nutripro.ui.theme.NutriPROTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriPROTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
