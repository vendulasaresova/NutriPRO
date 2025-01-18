package com.example.nutripro.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutripro.ui.theme.NutriPROTheme
import com.example.snapminder.ui.theme.MainColor
import com.example.snapminder.ui.theme.MainColor20

@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "User Profile",
            style = MaterialTheme.typography.titleLarge,
            color = MainColor,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        ProfileCard(label = "Name", value = "John Doe")
        ProfileCard(label = "Age", value = "29 years")
        ProfileCard(label = "Gender", value = "Male")
        ProfileCard(label = "Weight", value = "75 kg")
        ProfileCard(label = "Height", value = "180 cm")
        ProfileCard(label = "Goal", value = "Maintain current weight")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Additional Notes:",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "John enjoys hiking and cycling on weekends. He follows a balanced diet and prioritizes regular physical activity.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun ProfileCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MainColor20
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    NutriPROTheme {
        AccountScreen()
    }
}
