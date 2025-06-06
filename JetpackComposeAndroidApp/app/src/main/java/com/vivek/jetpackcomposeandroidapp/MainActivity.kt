package com.vivek.jetpackcomposeandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivek.jetpackcomposeandroidapp.ui.theme.JetpackComposeAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeAndroidAppTheme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}

enum class AppScreen { Home, Info, Graph, Overview }

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = AppScreen.Home.name) {
        composable(AppScreen.Home.name) {
            HomeScreen(navController)
        }
        composable(AppScreen.Info.name) {
            InfoScreen(navController)
        }
        composable(AppScreen.Graph.name) {
            GraphScreen(navController)
        }
        composable(AppScreen.Overview.name) {
            OverviewScreen(navController)
        }
    }
}