package com.vivek.jetpackcomposeandroidapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun PageTemplate(navController: NavController, heading: String, subheading: String) {
    val pages = listOf(
        "Information" to AppScreen.Info.name,
        "Graph" to AppScreen.Graph.name,
        "Overview" to AppScreen.Overview.name
    )
    // Find the current route by matching the heading
    val currentRoute = when (heading) {
        "Information" -> AppScreen.Info.name
        "Graph" -> AppScreen.Graph.name
        "Overview" -> AppScreen.Overview.name
        else -> ""
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(Modifier.height(24.dp))

        Surface(
            tonalElevation = 2.dp,
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.navigate(AppScreen.Home.name) },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                    modifier = Modifier.padding(end = 12.dp)
                ) {
                    Text("Back to Home")
                }
                LazyRow(
                    modifier = Modifier.weight(1f)
                ) {
                    items(pages) { (title, route) ->
                        Button(
                            onClick = { if (route != currentRoute) navController.navigate(route) },
                            enabled = route != currentRoute,
                            colors = if (route == currentRoute)
                                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                            else
                                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text(title)
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        Text(heading, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(8.dp))
        Text(subheading, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onBackground)
    }
}