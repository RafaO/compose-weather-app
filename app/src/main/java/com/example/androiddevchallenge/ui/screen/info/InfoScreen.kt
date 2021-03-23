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

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.ui.UiUtils
import com.example.androiddevchallenge.ui.composables.TemperatureText
import com.example.androiddevchallenge.viewmodel.HomeViewModel

data class InfoScreenState(val cityInfo: CityInfo, val selectedDay: String)

@Composable
fun InfoScreen(infoScreenState: InfoScreenState, viewModel: HomeViewModel) {
    val resources = LocalContext.current.resources

    Column(
        modifier = Modifier
            .semantics {
                contentDescription = resources.getString(R.string.content_description_info_screen)
            }
            .fillMaxSize()
            .padding(top = 16.dp)
            .background(color = MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        with(infoScreenState) {
            Text(selectedDay)
            Crossfade(targetState = cityInfo.dayTemp(selectedDay)) {
                TemperatureText(
                    temperature = it,
                    MaterialTheme.typography.h1
                )
            }
            Text(cityInfo.name)
            Spacer(Modifier.height(16.dp))
            WeekForecast(cityInfo.weekForecast, selectedDay) { viewModel.dayPressed(it) }
            Spacer(Modifier.height(16.dp))
            cityInfo.getDayForecast(selectedDay)?.hoursForecast?.let {
                HoursForecast(it, UiUtils())
            }
        }
    }
}
