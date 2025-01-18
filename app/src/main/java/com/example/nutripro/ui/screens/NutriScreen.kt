package com.example.nutripro.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapminder.ui.theme.MainColor
import kotlinx.coroutines.delay

@Composable
fun NutriScreen(modifier: Modifier = Modifier) {
    var isSecondMessageVisible by remember { mutableStateOf(false) }
    var joke by remember { mutableStateOf<Joke?>(null) }

    LaunchedEffect(Unit) {
        joke = ApiService.fetchRandomJoke()
        delay(5000)
        isSecondMessageVisible = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (joke == null) {
            TypingIndicator(isFromLeft = true)
        } else {
            TalkingBubble(
                text = joke!!.setup,
                isFromLeft = true
            )
        }

        if (isSecondMessageVisible) {
            TalkingBubble(
                text = joke?.punchline ?: "Loading punchline...",
                isFromLeft = false
            )
        } else {
            TypingIndicator(isFromLeft = false)
        }
    }
}


@Composable
fun TalkingBubble(text: String, isFromLeft: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = if (isFromLeft) Arrangement.Start else Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isFromLeft) MainColor else Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
                .widthIn(min = 50.dp, max = 300.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                color = if (isFromLeft) Color.White else Color.Black
            )
        }
    }
}

@Composable
fun TypingIndicator(isFromLeft: Boolean) {
    var dots by remember { mutableStateOf(".") }

    LaunchedEffect(Unit) {
        while (true) {
            dots = when (dots) {
                "." -> ".."
                ".." -> "..."
                "..." -> "."
                else -> "."
            }
            delay(500)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = if (isFromLeft) Arrangement.Start else Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isFromLeft) MainColor else Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
                .width(14.dp)
        ) {
            Text(
                text = dots,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                color = if (isFromLeft) Color.White else Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NutriScreenPreview() {
    NutriScreen(
        modifier = Modifier
    )
}