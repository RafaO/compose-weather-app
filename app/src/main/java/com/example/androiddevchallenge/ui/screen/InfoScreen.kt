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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.domain.model.HourForecast

@Composable
fun InfoScreen(cityInfo: CityInfo) = Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(cityInfo.temperature, style = MaterialTheme.typography.h1)
    Text(cityInfo.name)
    HoursForecast(cityInfo.todayForecast)
}

@Composable
fun HoursForecast(forecast: List<HourForecast>) = LazyRow(Modifier.fillMaxWidth()) {
    items(forecast) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(it.time)
            Text(it.temperature)
        }
    }
}
