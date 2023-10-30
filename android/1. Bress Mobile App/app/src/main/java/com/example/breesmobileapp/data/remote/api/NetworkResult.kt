package com.example.breesmobileapp.data.remote.api

// Event Wrapper
sealed class NetworkResult<T : Any> {
    class Success<T : Any>(val code: Int, val data: T) : NetworkResult<T>()
    class Error<T : Any>(val code: Int, val errorMsg: String?) : NetworkResult<T>()
    class Exception<T : Any>(val e: Throwable) : NetworkResult<T>()
}

sealed class DataState<out T : Any> {
    object Init : DataState<Nothing>() // State Loading
    data class Success<out T : Any>(val data: T) : DataState<T>() // State Success
    data class Failure(val errorMsg: String?) : DataState<Nothing>() // State Failure
}

fun <T : Any> NetworkResult<T>.convertToDataState(): DataState<T> {
    return when (this) {
        is NetworkResult.Success -> DataState.Success(this.data)
        is NetworkResult.Error -> DataState.Failure(this.errorMsg)
        is NetworkResult.Exception -> DataState.Failure(this.e.message)
    }
}