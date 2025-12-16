package com.example.news_app_roaminrabbit.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news_app_roaminrabbit.ui.feature.login.LoginScreen
import com.example.news_app_roaminrabbit.ui.feature.main.MainScreen
import com.example.news_app_roaminrabbit.ui.feature.splash.SplashScreen
import com.example.news_app_roaminrabbit.ui.theme.NewsApproaminrabbitTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsApproaminrabbitTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = SplashRoute
                ) {
                    composable<SplashRoute> {
                        SplashScreen(
                            viewModel = hiltViewModel(),
                            onNavigateToHome = { navController.navigate(MainRoute) {
                                popUpTo(SplashRoute) { inclusive = true }
                            } },
                            onNavigateToLogin = { navController.navigate(LoginRoute) {
                                popUpTo(SplashRoute) { inclusive = true }
                            } }
                        )
                    }
                    composable<LoginRoute> {
                        LoginScreen (
                            onLoginSuccess = {
                                navController.navigate(MainRoute) {
                                    popUpTo(LoginRoute) { inclusive = true }
                                }
                            }
                        )
                    }

                    composable<MainRoute> {
                        val mainNavController = rememberNavController()
                        MainScreen(navController = mainNavController)
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsApproaminrabbitTheme {
        Greeting("Android")
    }
}