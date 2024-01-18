package com.iessanalberto.dam2.iniciosesionfp24.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iessanalberto.dam2.iniciosesionfp24.states.UiState

class ViewModelHome : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

}