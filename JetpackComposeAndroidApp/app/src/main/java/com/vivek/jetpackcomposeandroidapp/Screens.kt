package com.vivek.jetpackcomposeandroidapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController) {
    PageTemplate(
        navController = navController,
        heading = "Information",
        subheading = "All the details you need."
    )
}

@Composable
fun GraphScreen(navController: NavController) {
    PageTemplate(
        navController = navController,
        heading = "Graph",
        subheading = "Visualize your data here."
    )
}

@Composable
fun OverviewScreen(navController: NavController) {
    PageTemplate(
        navController = navController,
        heading = "Overview",
        subheading = "Summary and highlights."
    )
}