package com.valllent.shared.logic.domain.data

sealed class ResultWrapper<T> {

    class Success<T>(val data: T) : ResultWrapper<T>()

    class Failure<T>(val errorMessage: String) : ResultWrapper<T>()

    fun on(success: (T) -> Unit, failure: (String) -> Unit = {}) {
        if (this is Success) {
            success(this.data)
        } else if (this is Failure) {
            failure(this.errorMessage)
        }
    }

}
