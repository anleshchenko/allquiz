package com.leshchenko.allquiz.presentation.ui.event

sealed interface MainUiEvent : UiEvent {
    object RandomQuizClicked : MainUiEvent
}