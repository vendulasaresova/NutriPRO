package com.example.nutripro.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutripro.ui.theme.NutriPROTheme
import com.example.nutripro.R
import com.example.snapminder.ui.theme.MainColor
import com.example.snapminder.ui.theme.White


@Composable
fun WelcomeScreen(onGetStartedClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.nutrition_main),
            contentDescription = "Main Nutrition Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Let's make some changes together.")

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onGetStartedClick,
            colors = ButtonDefaults.buttonColors(containerColor = MainColor)
        ) {
            Text(text = "Get Started")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    NutriPROTheme {
        WelcomeScreen(onGetStartedClick = { /* Preview action */ })
    }
}
