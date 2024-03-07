package com.iessanalberto.dam2.iniciosesionfp24.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iessanalberto.dam2.iniciosesionfp24.conexion.ConexionMySQL
import com.iessanalberto.dam2.iniciosesionfp24.conexion.Proyecto
import com.iessanalberto.dam2.iniciosesionfp24.states.UiState
import kotlinx.coroutines.launch

class ViewModelHome : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

    fun obtenerProyectos() {
        viewModelScope.launch {
            try {
                val proyectos = obtenerProyectosDeBD()
                _uiState.value = UiState(success = proyectos)
            } catch (e: Exception) {
                _uiState.value = UiState(error = e.message)
            }
        }
    }

    //con la conexion creo una query para sacar los datos de la base de datos y los añado a una lista proyectos
    fun obtenerProyectosDeBD(): List<Proyecto> {
        val proyectos = mutableListOf<Proyecto>()
        val con = ConexionMySQL.conectar("FP24MJO")
        val stmt = con?.createStatement()
        val rs = stmt?.executeQuery("SELECT * FROM PROJECT")
        while (rs?.next() == true) {
            val id = rs.getInt("Id")
            val title = rs.getString("Title")
            val description = rs.getString("ProjectDescription")
            val state = rs.getString("State")
            proyectos.add(Proyecto(id, title, description, state))
        }
        return proyectos
    }
}
