package com.leshchenko.allquiz.presentation.ui.state

import kotlinx.parcelize.Parcelize

@Parcelize
data class MainUiState(
    val isRandomQuizVisible: Boolean
) : UiState {

    companion object {
        val DEFAULT = MainUiState(isRandomQuizVisible = true)
    }
}