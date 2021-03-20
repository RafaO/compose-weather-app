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
import androidx.compose.ui.test.onNodeWithText
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Rule
import org.junit.Test

class HomeTest {

    @get:Rule
    val composeTestRule = createComposeRule() // if you don't need access to the activityTestRule

    @Test
    fun cityNameIsDisplayed() {
        // Start the app
        composeTestRule.setContent {
            MyTheme {
                Home()
            }
        }

        composeTestRule.onNodeWithText("Córdoba").assertIsDisplayed()
    }
}
