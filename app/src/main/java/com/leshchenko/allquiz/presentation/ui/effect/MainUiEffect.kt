package com.leshchenko.allquiz.presentation.ui.effect

sealed interface MainUiEffect : UiEffect {

    object NavigateToRandomQuiz : MainUiEffect
}