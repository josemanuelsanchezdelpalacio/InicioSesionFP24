package com.iessanalberto.dam2.iniciosesionfp24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.iniciosesionfp24.models.ViewModelLogin
import com.iessanalberto.dam2.iniciosesionfp24.models.ViewModelHome
import com.iessanalberto.dam2.iniciosesionfp24.models.ViewModelRegister
import com.iessanalberto.dam2.iniciosesionfp24.screens.HomeScreen
import com.iessanalberto.dam2.iniciosesionfp24.screens.LoginScreen
import com.iessanalberto.dam2.iniciosesionfp24.screens.RegisterScreen

@Composable
fun appNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(route = AppScreens.LoginScreen.route) { LoginScreen(navController, mvvm = ViewModelLogin()) }
        composable(route = AppScreens.RegisterScreen.route) { RegisterScreen(navController, mvvm = ViewModelRegister()) }
        composable(route = AppScreens.HomeScreen.route) { HomeScreen(navController, mvvm = ViewModelHome()) }
    }
}