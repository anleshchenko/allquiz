package com.leshchenko.allquiz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.leshchenko.allquiz.presentation.ui.effect.UiEffect
import com.leshchenko.allquiz.presentation.ui.event.UiEvent
import com.leshchenko.allquiz.presentation.ui.state.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filterNotNull

abstract class BaseViewModel<S : UiState, EF : UiEffect, EV : UiEvent> : ViewModel() {

    private val _stateFlow = MutableStateFlow<S?>(null)
    val stateFlow get() = _stateFlow.filterNotNull()

    private val _effectFlow = MutableSharedFlow<EF>()
    val effectFlow: Flow<EF> get() = _effectFlow.asSharedFlow()

    protected fun updateState(state: S) {
        _stateFlow.value = state
    }

    protected fun sendEffect(effect: EF) {
        _effectFlow.tryEmit(effect)
    }

    abstract fun handleEvent(event: EV)
}