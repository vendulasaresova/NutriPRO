package com.example.nutripro.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.snapminder.ui.theme.MainColor
import com.example.snapminder.ui.theme.MainColor30
import com.example.snapminder.ui.theme.MainColor60
import com.example.snapminder.ui.theme.MainColorDark
import com.example.snapminder.ui.theme.MainColorDark70

private val DarkColorScheme = darkColorScheme(
    primary = MainColor,
    secondary = MainColor60,
    tertiary = MainColor30
)

private val LightColorScheme = lightColorScheme(
    primary = MainColor,
    secondary = MainColorDark,
    tertiary = MainColorDark70
)

@Composable
fun NutriPROTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}