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

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.HourForecast
import com.example.androiddevchallenge.ui.UiUtils
import com.example.androiddevchallenge.ui.composables.TemperatureText
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// dimensions
const val GRAPH_HEIGHT = 200
const val BOTTOM_PADDING = 40
const val TAG_HEIGHT = 20
const val BUFFER = 5

@Composable
fun HoursForecast(hoursForecast: List<HourForecast>, uiUtils: UiUtils) = Column(
    Modifier
        .padding(start = 16.dp)
        .fillMaxWidth()
) {
    Text(stringResource(R.string.each_hour), style = MaterialTheme.typography.h5)
    Row(Modifier.height(GRAPH_HEIGHT.dp)) {
        Column(
            Modifier
                .fillMaxHeight()
                .padding(bottom = BOTTOM_PADDING.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("100")
            Text("50")
            Text("0")
        }
        LazyRow(Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
            itemsIndexed(hoursForecast) { index, hour -> Hour(hour, uiUtils, index) }
        }
    }
}

@Composable
fun Hour(it: HourForecast, uiUtils: UiUtils, position: Int) {
    var expanded by remember { mutableStateOf(false) }
    val height by animateDpAsState(
        if (expanded) uiUtils.getRainChanceBarHeight(
            it.rainChanceAsInt(),
            GRAPH_HEIGHT - BOTTOM_PADDING - TAG_HEIGHT - BUFFER
        ) else 0.dp
    )

    val scope = rememberCoroutineScope()

    scope.launch {
        delay(100L * position)
        expanded = true
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(it.rainChance, Modifier.height(TAG_HEIGHT.dp))
        Column(
            Modifier
                .background(color = MaterialTheme.colors.primaryVariant)
                .height(height)
                .width(10.dp)
        ) {}
        Text(it.time)
        TemperatureText(it.temperature)
    }
    Spacer(Modifier.width(24.dp))
}
