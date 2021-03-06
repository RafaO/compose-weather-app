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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.model.DayForecast
import com.example.androiddevchallenge.ui.composables.TemperatureText

@Composable
fun WeekForecast(forecast: List<DayForecast>, daySelected: String, onDayClicked: (String) -> Unit) {

    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
    ) {
        items(forecast.size) { index ->
            DayForecast(forecast[index], forecast[index].day == daySelected) {
                onDayClicked(forecast[index].day)
            }
        }
    }
}

@Composable
fun DayForecast(forecast: DayForecast, selected: Boolean, onClick: () -> Unit) = Row {
    Box(
        Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.secondaryVariant,
                shape = CircleShape
            )
    ) {
        val textColor =
            if (selected) MaterialTheme.colors.background else MaterialTheme.colors.onSurface
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = if (selected) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface)
                .height(130.dp)
                .width(75.dp)
        ) {
            Text(forecast.day, color = textColor, fontSize = 14.sp)
            Icon(
                imageVector = forecast.icon,
                contentDescription = forecast.temperature,
                tint = textColor,
                modifier = Modifier.size(24.dp)
            )
            TemperatureText(
                temperature = forecast.temperature,
                color = textColor,
            )
        }
    }
    Spacer(Modifier.width(8.dp))
}
