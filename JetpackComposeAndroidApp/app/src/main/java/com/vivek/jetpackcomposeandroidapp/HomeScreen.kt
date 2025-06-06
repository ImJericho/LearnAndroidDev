package com.vivek.jetpackcomposeandroidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("My App", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
        Spacer(Modifier.height(32.dp))
        CardView(
            title = "Information Page",
            description = "Navigate to the information page to learn more about the app.",
            color = Color(0xFFE3F2FD),
            onClick = { navController.navigate(AppScreen.Info.name) }
            )
        Spacer(Modifier.height(12.dp))
        CardView(
            title = "Graph Page",
            description = "Navigate to the graph page to visualize your data.",
            color = Color(0xFFFFF9C4),
            onClick = { navController.navigate(AppScreen.Graph.name) }
            )
        Spacer(Modifier.height(12.dp))
        CardView(
            title = "Overview Page",
            description = "Navigate to the overview page for a summary of your data.",
            color = Color(0xFFC8E6C9),
            onClick = { navController.navigate(AppScreen.Overview.name) }
            )
    }
}

@Composable
fun CardView(
    title: String,
    description: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.tertiaryContainer
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.height(4.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
