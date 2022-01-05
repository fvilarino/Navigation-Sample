package com.francescsoftware.navigationsample.two

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class TwoState(
    val value: String,
)

@HiltViewModel
class TwoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state = mutableStateOf(TwoState(""))
        private set

    init {
        val argument = savedStateHandle.get<String>(DestinationOneArg).orEmpty()
        state.value = state.value.copy(
            value = argument,
        )
    }
}
