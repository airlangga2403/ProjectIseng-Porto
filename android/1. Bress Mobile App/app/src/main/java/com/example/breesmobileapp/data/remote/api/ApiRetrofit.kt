package com.example.breesmobileapp.data.remote.api

import android.util.Log
import com.example.breesmobileapp.data.remote.ApiServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRetrofit {
    private val BASE_URL: String = "https://BASE_URL.COM"

    var retrofitServ: ApiServices?


    init {
        retrofitServ = null // init if run first == null
    }

    fun setupBaseURL() {
        try {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(HttpClientWithIntercept.client)
        } catch (e: Exception) {
            Log.e("exception", "message : ${e.message.toString()}")
        }
    }

    object HttpClientWithIntercept {
        val client: OkHttpClient

        init {
            client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
//                .addInterceptor(HeaderInterceptor)
                .build();
        }
    }

    object HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val modifiedRequest = originalRequest.newBuilder()
                .header(
                    "X-RapidAPI-Key",
                    "71c648bc0cmshe9ddfd78997b89ep179d2cjsn8d1411198a4f"
                ) // example if need key
                .header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com") // host header
                .build()
            return chain.proceed(modifiedRequest)
        }
    }


}