package com.skycast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skycast.ui.screens.DashboardScreen
import com.skycast.ui.screens.SearchScreen
import com.skycast.ui.theme.SkyCastTheme
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.gms.ads.MobileAds

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize the Google Mobile Ads SDK
        MobileAds.initialize(this) {}
        
        setContent {
            SkyCastTheme {
                SkyCastApp()
            }
        }
    }
}

@Composable
fun SkyCastApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(
                onNavigateToSearch = { navController.navigate("search") }
            )
        }
        composable("search") {
            SearchScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
