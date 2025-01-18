package com.example.nutripro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import com.example.snapminder.ui.theme.White
import com.example.snapminder.ui.theme.MainColor
import com.example.nutripro.R

@Composable
fun HomeScreen(data: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Welcome to NutriPro",
                color = MainColor,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "NutriPro is your go-to tool. " +
                        "Powered by the Jokes API, this app helps you:\n\n" +
                        "• Get a funny joke every day to keep you happy in this hard fitness time.\n\n" +
                        "Start your journey to a healthier you today!"
            )
        }

        Image(
            painter = painterResource(id = R.drawable.nutri_page),
            contentDescription = "Main Nutrition Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(data = "This is a dump of some data for preview!")
}
