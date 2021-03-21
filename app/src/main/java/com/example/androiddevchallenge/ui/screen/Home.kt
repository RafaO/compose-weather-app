/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ViewModelFactory
import com.example.androiddevchallenge.ui.screen.info.InfoScreen
import com.example.androiddevchallenge.ui.screen.info.InfoScreenState
import com.example.androiddevchallenge.ui.screen.loading.LoadingScreen
import com.example.androiddevchallenge.viewmodel.HomeViewModel

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    data class Info(val infoState: InfoScreenState) : HomeScreenState()
    object Error : HomeScreenState()
}

@Composable
fun Home(viewModel: HomeViewModel = viewModel(factory = ViewModelFactory())) {
    val state by viewModel.state.observeAsState(HomeScreenState.Loading)

    Content(state, viewModel)
}

@Composable
fun Content(state: HomeScreenState, homeViewModel: HomeViewModel) {
    when (state) {
        is HomeScreenState.Loading -> LoadingScreen()
        is HomeScreenState.Info -> InfoScreen(state.infoState, homeViewModel)
        is HomeScreenState.Error -> ErrorScreen()
    }
}

@Composable
fun ErrorScreen() = Text(stringResource(R.string.error))
