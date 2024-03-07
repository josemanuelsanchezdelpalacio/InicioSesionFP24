package com.iessanalberto.dam2.iniciosesionfp24.conexion

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


data class Proyecto(
    val id: Int,
    val title: String,
    val description: String,
    val state: String
)

object ConexionMySQL {
    private const val URL = "jdbc:mysql://54.37.220.4:3306/"
    private const val USUARIO = "MNJMSOG24"
    private const val CLAVE = "G-UMg2[fdFk18o"

    fun conectar(nombreBD: String): Connection? {
        var conexion: Connection? = null
        try {
            conexion = DriverManager.getConnection(URL + nombreBD, USUARIO, CLAVE)
        } catch (e: SQLException) {
            println("Error en la conexión: " + e.message)
            e.printStackTrace()
        }
        return conexion
    }
}
