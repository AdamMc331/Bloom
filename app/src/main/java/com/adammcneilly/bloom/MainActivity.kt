package com.adammcneilly.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.bloom.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                val navController = rememberNavController()

                NavHost(navController, "home") {
                    composable("welcome") {
                        WelcomeScreen(navController)
                    }
                    composable("login") {
                        LoginScreen()
                    }
                    composable("home") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
