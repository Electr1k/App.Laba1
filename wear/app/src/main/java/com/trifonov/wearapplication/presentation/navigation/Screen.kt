package com.trifonov.wearapplication.presentation.navigation

enum class Screen(
    val route: String,
    val title: String
) {
    Auth(
        route = "auth",
        title = "Авторизация",
    ),
    Main(
        route = "main",
        title = "Главная",
    ),
}