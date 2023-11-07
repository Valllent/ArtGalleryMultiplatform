package com.valllent.shared.logic.domain.data

sealed class ResultWrapper<T> {

    companion object {
        suspend fun <T> from(
            errorMessage: String = "Network Error",
            code: suspend () -> T?
        ): ResultWrapper<T> {
            val runner = runCatching { code() }

            val result = runner.getOrNull()
            if (result != null) {
                return Success(result)
            }

            val exception = runner.exceptionOrNull()
            return Failure("$errorMessage: $exception")
        }
    }

    class Success<T>(val data: T) : ResultWrapper<T>()

    class Failure<T>(val errorMessage: String) : ResultWrapper<T>()

    fun on(success: (T) -> Unit, failure: (String) -> Unit = {}) {
        if (this is Success) {
            success(this.data)
        } else if (this is Failure) {
            failure(this.errorMessage)
        }
    }

    fun resultOrNull(): T? {
        if (this is Success) {
            return this.data
        }
        return null
    }

}
