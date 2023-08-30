package com.leshchenko.allquiz.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leshchenko.allquiz.R
import com.leshchenko.allquiz.presentation.ui.effect.MainUiEffect
import com.leshchenko.allquiz.presentation.ui.event.MainUiEvent
import com.leshchenko.allquiz.presentation.ui.state.MainUiState
import com.leshchenko.allquiz.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    val state = viewModel.stateFlow.collectAsStateWithLifecycle(initialValue = MainUiState.DEFAULT)
    val effect = viewModel.effectFlow.collectAsStateWithLifecycle(initialValue = null)

    effect.value?.let { HandleUiEffect(effect = it) }
    MainScreen(viewModel = viewModel, state = state.value)
}

@Composable
private fun MainScreen(viewModel: MainViewModel, state: MainUiState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (state.isRandomQuizVisible) {
            RandomQuizCard { viewModel.handleEvent(MainUiEvent.RandomQuizClicked) }
        }
    }
}

@Composable
private fun RandomQuizCard(onClick: () -> Unit) {
    Card(
        onClick = { onClick() },
    ) {
        val randomQuiz = stringResource(id = R.string.random_quiz)
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                imageVector = Icons.Default.Star,
                contentDescription = randomQuiz,
            )
            Text(
                text = randomQuiz,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
            )
        }
    }
}

@Composable
private fun HandleUiEffect(effect: MainUiEffect) {
    when (effect) {
        is MainUiEffect.NavigateToRandomQuiz -> {
            // TODO Navigate to random quiz
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}