package com.example.nutripro.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.nutripro.ui.components.BottomNavItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.snapminder.ui.theme.MainColor
import com.example.snapminder.ui.theme.White
import com.example.snapminder.ui.theme.MediumGrey

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = White,
        contentColor = MediumGrey,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 4.dp)
    ) {
        val currentRoute by navController.currentBackStackEntryAsState()
        val items = listOf(
            BottomNavItem("home", Icons.Default.Home, "Home"),
            BottomNavItem("nutri", Icons.Default.List, "Jokes chat"),
            BottomNavItem("account", Icons.Default.AccountCircle, "Account")
        )

        items.forEach { item ->
            val isSelected = currentRoute?.destination?.route == item.route

            NavigationBarItem(
                icon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = if (isSelected) MainColor.copy(alpha = 0.2f) else Color.Transparent,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (isSelected) MainColor else MediumGrey
                        )
                    }
                },
                label = {
                    Text(
                        item.title,
                        color = if (isSelected) MainColor else MediumGrey
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MainColor,
                    unselectedIconColor = MediumGrey,
                    selectedTextColor = MainColor,
                    unselectedTextColor = MediumGrey,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    BottomNavigationBar(navController)
}
