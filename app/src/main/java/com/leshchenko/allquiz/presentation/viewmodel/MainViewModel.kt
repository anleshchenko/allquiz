package com.leshchenko.allquiz.presentation.viewmodel

import com.leshchenko.allquiz.presentation.ui.effect.MainUiEffect
import com.leshchenko.allquiz.presentation.ui.event.MainUiEvent
import com.leshchenko.allquiz.presentation.ui.state.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() :
    BaseViewModel<MainUiState, MainUiEffect, MainUiEvent>() {

    override fun handleEvent(event: MainUiEvent) {
        when (event) {
            MainUiEvent.RandomQuizClicked -> sendEffect(MainUiEffect.NavigateToRandomQuiz)
        }
    }
}