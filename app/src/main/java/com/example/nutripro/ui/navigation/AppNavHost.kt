package com.example.nutripro.navigation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nutripro.ui.components.HomeScreen
import com.example.nutripro.ui.components.NutriScreen
import com.example.nutripro.ui.components.AccountScreen
import com.example.nutripro.ui.screens.WelcomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            val currentBackStack by navController.currentBackStackEntryAsState()
            if (currentBackStack?.destination?.route != "welcome") {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcome",
            Modifier.padding(innerPadding)
        ) {
            composable("welcome") {
                WelcomeScreen(onGetStartedClick = {
                    Log.d("Navigation", "Get Started clicked, navigating to Home")
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                })
            }
            composable("home") {
                HomeScreen(data = "Debug Info: Some sample data")
            }
            composable("nutri") {
                NutriScreen()
            }
            composable("account") {
                AccountScreen()
            }
        }
    }
}
