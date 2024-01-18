package com.iessanalberto.dam2.iniciosesionfp24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.iessanalberto.dam2.iniciosesionfp24.navigation.appNavigation

import com.iessanalberto.dam2.iniciosesionfp24.ui.theme.InicioSesionFP24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InicioSesionFP24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    appNavigation()
                }
            }
        }
    }
}