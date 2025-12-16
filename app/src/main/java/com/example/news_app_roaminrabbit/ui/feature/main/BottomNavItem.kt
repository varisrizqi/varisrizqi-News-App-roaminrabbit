package com.example.news_app_roaminrabbit.ui.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.news_app_roaminrabbit.app.HomeRoute
import com.example.news_app_roaminrabbit.app.NewsRoute
import com.example.news_app_roaminrabbit.app.ProfileRoute

data class BottomNavItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(
        route = HomeRoute,
        label = "Home",
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        route = NewsRoute,
        label = "News",
        icon = Icons.Default.List
    ),
    BottomNavItem(
        route = ProfileRoute,
        label = "Profile",
        icon = Icons.Default.Person
    )
)
