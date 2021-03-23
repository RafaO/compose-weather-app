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

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.androiddevchallenge.domain.model.CityInfo
import com.example.androiddevchallenge.domain.usecase.BaseUseCase
import com.example.androiddevchallenge.domain.usecase.GetWeekWeatherUseCase
import com.example.androiddevchallenge.domain.usecase.invoke
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class HomeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingScreenIsDisplayed() {
        // Start the app
        composeTestRule.setContent {
            MyTheme {
                Home()
            }
        }

        composeTestRule.onNodeWithContentDescription("Loading screen").assertIsDisplayed()
    }

    @Test
    fun whenDataArrives_InfoScreenIsDisplayed() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        coEvery { useCase() } returns BaseUseCase.Result.Success(CityInfo("Málaga", emptyList()))
        val viewModel = HomeViewModel(useCase)

        // when
        composeTestRule.setContent {
            MyTheme {
                Home(viewModel)
            }
        }

        // then
        composeTestRule.onNodeWithContentDescription("info screen").assertIsDisplayed()
    }

    @Test
    fun whenError_errorScreenIsDisplayed() {
        // given
        val useCase = mockk<GetWeekWeatherUseCase>()
        coEvery { useCase() } returns BaseUseCase.Result.Failure()
        val viewModel = HomeViewModel(useCase)

        // when
        composeTestRule.setContent {
            MyTheme {
                Home(viewModel)
            }
        }

        // then
        composeTestRule.onNodeWithContentDescription("error screen").assertIsDisplayed()
    }
}
