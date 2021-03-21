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

abstract class BaseUseCase<in TParam, out TResult> {
    sealed class Result<out TResultModel> {
        data class Success<out TResultModel>(val result: TResultModel) :
            Result<TResultModel>()

        data class Failure(val error: Exception? = null) : Result<Nothing>()
    }

    suspend operator fun invoke(param: TParam) = try {
        performAction(param)
    } catch (exception: Exception) {
        Result.Failure(exception)
    }

    protected abstract suspend fun performAction(param: TParam): Result<TResult>
}

suspend operator fun <R> BaseUseCase<Unit, R>.invoke(): BaseUseCase.Result<R> = this(Unit)
