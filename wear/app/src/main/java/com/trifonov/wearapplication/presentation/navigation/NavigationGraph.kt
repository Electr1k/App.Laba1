package com.trifonov.wearapplication.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.trifonov.wearapplication.presentation.AuthScreen
import com.trifonov.wearapplication.presentation.MainScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
) {

    fun navigateByRoute(
        route: String,
        popUpRoute: String? = null,
        isInclusive: Boolean = false,
        isSingleTop: Boolean = true,
    ) {
        navController.navigate(route) {
            popUpRoute?.let { popUpToRoute ->
                popUpTo(popUpToRoute) {
                    inclusive = isInclusive
                }
            }
            launchSingleTop = isSingleTop
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route,
    ) {
        composable(route = Screen.Auth.route) {
            AuthScreen(navigationByRoute = {navigateByRoute(it)})
        }
        composable(route = Screen.Main.route){
            MainScreen()
        }
    }
}