package com.example.breesmobileapp.data.remote.api

import android.util.Log
import retrofit2.HttpException
import retrofit2.Response


interface ApiHandler {

    companion object {
        private val TAG = "ApiHandler"
        private val TAG_FIREBASE = "ApiHandler"
    }

    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {

        return try {

            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                // Berikan hasil sukses dan log pesan
                Log.d(TAG, "Success - Code: ${response.code()}, Message: ${response.message()}")
                NetworkResult.Success(response.code(), body)
            } else {
                // Berikan hasil error dan log pesan
                Log.e(
                    TAG,
                    "Error - Code: ${response.code()}, Error Message: ${
                        response.errorBody().toString()
                    }"
                )
                NetworkResult.Error(
                    code = response.code(),
                    errorMsg = response.errorBody().toString()
                )
            }
        } catch (e: HttpException) {
            // Berikan hasil error HTTP dan log pesan
            Log.e(TAG, "HTTP Error - Code: ${e.code()}, Message: ${e.message()}")
            NetworkResult.Error(code = e.code(), errorMsg = e.message().toString())
        } catch (e: Throwable) {
            // Berikan hasil error umum dan log pesan
            Log.e(TAG, "Throwable Error - ${e.message.toString()}")
            NetworkResult.Exception(e)
        }

    }
}