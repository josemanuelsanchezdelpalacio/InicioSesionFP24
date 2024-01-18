package com.iessanalberto.dam2.iniciosesionfp24.states

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

data class UiState(
    var user: String = "",
    var password: String = "",
    var repeat_password: String = "",
    val auth: FirebaseAuth = Firebase.auth
)