package com.iessanalberto.dam2.iniciosesionfp24.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.iniciosesionfp24.conexion.Proyecto
import com.iessanalberto.dam2.iniciosesionfp24.models.ViewModelHome
import com.iessanalberto.dam2.iniciosesionfp24.states.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, mvvm: ViewModelHome) {
    val uiState by mvvm.uiState.observeAsState()

    LaunchedEffect(Unit) {
        mvvm.obtenerProyectos()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Factoria de Proyectos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atras")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Button(onClick = {  }) {
                    Text("Añadir")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {  }) {
                    Text("Eliminar")
                }
            }
        }
    ) { paddingValues ->
        homeScreenBody(modifier = Modifier.padding(paddingValues), navController, mvvm, uiState?.success)
    }
}

@Composable
fun homeScreenBody(modifier: Modifier, navController: NavController, mvvm: ViewModelHome, proyectos: List<Proyecto>?) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            items(proyectos?.size ?: 0) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Proyecto: ${proyectos?.get(index)?.title}")
                        Text(text = "Descripción: ${proyectos?.get(index)?.description}")
                        Text(text = "Estado: ${proyectos?.get(index)?.state}")
                    }
                }
            }
        }
    }
}



/*ASI SERIA PARA HACERLO CON APIARI
* @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, mvvm: ViewModelHome) {
    val service = RetrofitServiceFactory.makeRetrofitService()
    var proyectos by remember { mutableStateOf(mutableListOf<Proyecto>()) }

    // Llamar a la API al iniciar la pantalla
    LaunchedEffect(Unit) {
        val listProjects = service.listData()
        proyectos = listProjects.toMutableList()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Factoria de Proyectos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atras")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Button(onClick = { /* código para añadir un proyecto en el servidor */ }) {
                    Text("Añadir")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* código para eliminar un proyecto en el servidor */ }) {
                    Text("Eliminar")
                }
            }
        }
    ) { paddingValues ->
        homeScreenBody(modifier = Modifier.padding(paddingValues), navController, mvvm, proyectos)
    }
}

@Composable
fun homeScreenBody(modifier: Modifier, navController: NavController, mvvm: ViewModelHome, proyectos: MutableList<Proyecto>) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            items(proyectos.size) { proyecto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Proyecto: ${proyectos[proyecto].proyecto}")
                        Text(text = "Centro: ${proyectos[proyecto].centro}")
                        Text(text = "Responsable: ${proyectos[proyecto].responsable}")
                    }
                }
            }
        }
    }
}
*/