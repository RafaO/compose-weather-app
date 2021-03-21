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
package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.domain.usecase.BaseUseCase
import com.example.androiddevchallenge.domain.usecase.GetWeekWeatherUseCase
import com.example.androiddevchallenge.domain.usecase.invoke
import com.example.androiddevchallenge.ui.screen.HomeScreenState
import com.example.androiddevchallenge.ui.screen.info.InfoScreenState
import kotlinx.coroutines.launch

class HomeViewModel(getWeekWeatherUseCase: GetWeekWeatherUseCase) : ViewModel() {

    // Observables

    private val _state = MutableLiveData<HomeScreenState>(HomeScreenState.Loading)
    val state: LiveData<HomeScreenState> = _state

    init {
        viewModelScope.launch {
            _state.value = when (val result = getWeekWeatherUseCase()) {
                is BaseUseCase.Result.Success -> HomeScreenState.Info(
                    InfoScreenState(result.result, "Today")
                )
                else -> HomeScreenState.Error
            }
        }
    }

    // UI events

    fun dayPressed(day: String) {
        _state.value = (_state.value as? HomeScreenState.Info)?.let {
            it.copy(infoState = it.infoState.copy(selectedDay = day))
        }
    }
}
