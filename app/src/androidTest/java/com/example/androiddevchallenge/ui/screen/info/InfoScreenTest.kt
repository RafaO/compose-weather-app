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

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.androiddevchallenge.data.weatherData
import com.example.androiddevchallenge.domain.usecase.BaseUseCase
import com.example.androiddevchallenge.domain.usecase.GetWeekWeatherUseCase
import com.example.androiddevchallenge.domain.usecase.invoke
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.HomeViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class InfoScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun cityNameIsDisplayed() = runBlockingTest {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        val cityInfo = weatherData()
        coEvery { useCase() } returns BaseUseCase.Result.Success(cityInfo)
        // Start the app
        composeTestRule.setContent {
            MyTheme {
                InfoScreen(
                    InfoScreenState(cityInfo, "Today"), HomeViewModel(useCase)
                )
            }
        }

        composeTestRule.onNodeWithText("Córdoba").assertIsDisplayed()
    }

    @Test
    fun whenSelectedDAyChanges_TextIsUpdated() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        val cityInfo = weatherData()
        coEvery { useCase() } returns BaseUseCase.Result.Success(cityInfo)
        val viewModel = HomeViewModel(useCase)
        val infoState = mutableStateOf(InfoScreenState(cityInfo, "Today"))
        // Start the app
        composeTestRule.setContent {
            MyTheme {
                InfoScreen(infoState.value, viewModel)
            }
        }

        // when
        infoState.value = infoState.value.copy(selectedDay = "Tomorrow")

        // then
        composeTestRule.onNodeWithText("Tomorrow").assertIsDisplayed()
    }

    @Test
    fun whenDayIsPressed_DeliversEventToViewModel() {
        // given
        val viewModel = mockk<HomeViewModel>()
        every { viewModel.dayPressed(any()) } just runs
        // Start the app
        composeTestRule.setContent {
            MyTheme {
                InfoScreen(InfoScreenState(weatherData(), "Today"), viewModel)
            }
        }

        // when
        composeTestRule.onNodeWithText("Tomorrow", useUnmergedTree = true).performClick()

        // then
        verify { viewModel.dayPressed("Tomorrow") }
    }
}
