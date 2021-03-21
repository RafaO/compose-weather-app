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
package com.example.androiddevchallenge.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Storm
import androidx.compose.material.icons.filled.WbSunny
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.domain.model.DayForecast
import com.example.androiddevchallenge.domain.model.HourForecast
import kotlinx.coroutines.delay

class WeatherDataProvider {
    suspend fun getWeekInfo(): CityInfo {
        delay(1000)
        return CityInfo(
            "Córdoba",
            listOf(
                DayForecast(
                    "Today", "25°C", Icons.Filled.WbSunny,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Tomorrow", "30°C", Icons.Filled.Cloud,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Wednesday", "28°C", Icons.Filled.Storm,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Thursday", "28°C", Icons.Filled.Cloud,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Friday", "30°C", Icons.Filled.WbSunny,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Saturday", "29°C", Icons.Filled.WbSunny,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
                DayForecast(
                    "Sunday", "30°C", Icons.Filled.WbSunny,
                    listOf(
                        HourForecast("10AM", "18°C", "100%"),
                        HourForecast("11AM", "19°C", "20%"),
                        HourForecast("12AM", "20°C", "20%"),
                        HourForecast("1PM", "25°C", "20%"),
                        HourForecast("2PM", "25°C", "20%"),
                        HourForecast("3PM", "25°C", "20%"),
                        HourForecast("4PM", "25°C", "20%"),
                        HourForecast("5PM", "25°C", "20%"),
                        HourForecast("6PM", "25°C", "20%"),
                        HourForecast("7PM", "25°C", "20%"),
                        HourForecast("8PM", "25°C", "20%"),
                        HourForecast("9PM", "25°C", "20%"),
                        HourForecast("10PM", "25°C", "20%"),
                        HourForecast("11M", "25°C", "20%"),
                        HourForecast("12PM", "25°C", "20%"),
                    )
                ),
            )
        )
    }
}
