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
package com.example.androiddevchallenge.domain.usecase

import com.example.androiddevchallenge.data.WeatherDataProvider
import com.example.androiddevchallenge.domain.model.CityInfo
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GetWeekWeatherUseCaseTest {

    @Test
    fun `when executed, it calls the provider method`() = runBlockingTest {
        // given
        val provider = mockk<WeatherDataProvider>()
        val subject = GetWeekWeatherUseCase(provider)

        // when
        subject()

        // then
        coVerify { provider.getWeekInfo() }
    }

    @Test
    fun `when provider retrieves data, it delivers success`() = runBlockingTest {
        // given
        val provider = mockk<WeatherDataProvider>()
        val cityInfo = CityInfo("Sevilla", emptyList())
        coEvery { provider.getWeekInfo() } returns cityInfo
        val subject = GetWeekWeatherUseCase(provider)

        // when
        val result = subject()

        // then
        assertEquals(cityInfo, (result as BaseUseCase.Result.Success).result)
    }

    @Test
    fun `when provider throws exception, it delivers failure`() = runBlockingTest {
        // given
        val provider = mockk<WeatherDataProvider>()
        coEvery { provider.getWeekInfo() } throws IllegalStateException("ups")
        val subject = GetWeekWeatherUseCase(provider)

        // when
        val result = subject()

        // then
        assert(result is BaseUseCase.Result.Failure)
    }
}
