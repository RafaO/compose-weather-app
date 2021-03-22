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

import com.example.androiddevchallenge.data.WeatherDataProvider
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.domain.usecase.BaseUseCase
import com.example.androiddevchallenge.domain.usecase.GetWeekWeatherUseCase
import com.example.androiddevchallenge.domain.usecase.invoke
import com.example.androiddevchallenge.ui.screen.HomeScreenState
import com.example.androiddevchallenge.ui.screen.info.InfoScreenState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest : CoroutinesTest() {

    @Test
    fun `when created, it emits loading state`() {
        // given
        val useCase = GetWeekWeatherUseCase(WeatherDataProvider())

        // when
        val subject = HomeViewModel(useCase)

        // then
        assertEquals(HomeScreenState.Loading(), subject.state.getOrAwaitValue())
    }

    @Test
    fun `when data arrives, it emits info state with today selected`() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        val cityInfo = CityInfo("Málaga", emptyList())
        coEvery { useCase() } returns BaseUseCase.Result.Success(cityInfo)

        // when
        val subject = HomeViewModel(useCase)

        // then
        assertEquals(
            HomeScreenState.Info(InfoScreenState(cityInfo, "Today")),
            subject.state.getOrAwaitValue()
        )
    }

    @Test
    fun `when day is pressed, it updates the selected day`() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        val cityInfo = CityInfo("Málaga", emptyList())
        coEvery { useCase() } returns BaseUseCase.Result.Success(cityInfo)
        val subject = HomeViewModel(useCase)

        // when
        subject.dayPressed("wednesday")

        // then
        assertEquals(
            HomeScreenState.Info(InfoScreenState(cityInfo, "wednesday")),
            subject.state.getOrAwaitValue()
        )
    }

    @Test
    fun `when data fetch fails, it emits error state`() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        coEvery { useCase() } returns BaseUseCase.Result.Failure()

        // when
        val subject = HomeViewModel(useCase)

        // then
        assertEquals(HomeScreenState.Error, subject.state.getOrAwaitValue())
    }
}
