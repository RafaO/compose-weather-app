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

import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.domain.model.DayForecast
import com.example.androiddevchallenge.domain.model.HourForecast

class WeatherDataProvider {
    fun getWeekInfo() = CityInfo(
        "Córdoba",
        listOf(
            DayForecast(
                "Today", "25°C",
                listOf(
                    HourForecast("10:00 AM", "18°C"),
                    HourForecast("11:00 AM", "19°C"),
                    HourForecast("12:00 AM", "20°C"),
                    HourForecast("13:00 AM", "25°C"),
                )
            )
        )
    )
}
