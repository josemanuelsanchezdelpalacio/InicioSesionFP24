package com.iessanalberto.dam2.iniciosesionfp24.navigation

sealed class AppScreens (val route: String){
    object LoginScreen: AppScreens(route = "login_screen")
    object RegisterScreen: AppScreens(route = "register_screen")
    object HomeScreen: AppScreens(route = "home_screen")
}
