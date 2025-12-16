package com.example.news_app_roaminrabbit.ui.feature.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.news_app_roaminrabbit.app.HomeRoute
import com.example.news_app_roaminrabbit.app.LoginRoute
import com.example.news_app_roaminrabbit.app.MainRoute
import com.example.news_app_roaminrabbit.app.NewsRoute
import com.example.news_app_roaminrabbit.app.ProfileRoute
import com.example.news_app_roaminrabbit.ui.feature.main.home.HomeScreen
import com.example.news_app_roaminrabbit.ui.feature.main.news.NewsScreen
import com.example.news_app_roaminrabbit.ui.feature.main.profile.ProfileScreen

@Composable
fun MainScreen(
    rootNavController: NavHostController
) {
    val mainNavController = rememberNavController()

    val backStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route::class.qualifiedName,
                        onClick = {
                            mainNavController.navigate(item.route) {
                                popUpTo(HomeRoute) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(item.icon, contentDescription = item.label)
                        },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = mainNavController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<HomeRoute> { HomeScreen() }
            composable<NewsRoute> {  NewsScreen() }
            composable<ProfileRoute> {
                ProfileScreen(
                    onLogoutClick = {
                        rootNavController.navigate(LoginRoute) {
                            popUpTo(MainRoute) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}
