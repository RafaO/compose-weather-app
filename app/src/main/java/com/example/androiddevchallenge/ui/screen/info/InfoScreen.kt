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
package com.example.androiddevchallenge.ui.screen.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.ui.UiUtils
import com.example.androiddevchallenge.viewmodel.HomeViewModel

data class InfoScreenState(val cityInfo: CityInfo, val selectedDay: String)

@Composable
fun InfoScreen(infoScreenState: InfoScreenState, viewModel: HomeViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        with(infoScreenState) {
            Text(selectedDay)
            Text(cityInfo.dayTemp(selectedDay), style = MaterialTheme.typography.h1)
            Text(cityInfo.name)
            WeekForecast(cityInfo.weekForecast, selectedDay) { viewModel.dayPressed(it) }
            HoursForecast(cityInfo.getDayForecast(selectedDay).hoursForecast, UiUtils())
        }
    }
}
