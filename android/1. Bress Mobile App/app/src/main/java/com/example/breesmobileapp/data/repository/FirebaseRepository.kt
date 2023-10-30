package com.example.breesmobileapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.breesmobileapp.data.remote.api.NetworkResult
import com.example.breesmobileapp.data.remote.model.User
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

interface FirebaseRepository {

    // Firebase Auth
    fun signIn(email: String, password: String): LiveData<NetworkResult<User>>
    fun signUp(email: String, password: String): LiveData<NetworkResult<User>>
}


class FirebaseRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) :
    FirebaseRepository {

    companion object {
        private val TAG = "FirebaseRepository"
    }

    override fun signIn(email: String, password: String): LiveData<NetworkResult<User>> {
        val resultLiveData = MutableLiveData<NetworkResult<User>>()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                    val userData = User(user?.uid, user?.displayName, user?.email)

                    resultLiveData.value = NetworkResult.Success(200, userData)
                } else {
                    // Handle authentication failure here and log the error
                    val exception = task.exception
                    Log.e(TAG, "Sign In Failed: ${exception?.message}")
                    resultLiveData.value =
                        NetworkResult.Exception(exception ?: Exception("Unknown error"))
                }
            }

        return resultLiveData
    }

    override fun signUp(email: String, password: String): LiveData<NetworkResult<User>> {
        val resultLiveData = MutableLiveData<NetworkResult<User>>()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = task.result.user
                    val userData = User(user?.uid, user?.displayName, user?.email)
                    resultLiveData.postValue(NetworkResult.Success(200, userData))
                    Log.d(TAG, "Sign Up Success : ${userData?.email} + ${resultLiveData.value}")
                } else {
                    // Handle authentication failure here and log the error
                    val exception = task.exception
                    Log.e(TAG, "Sign Up Failed: ${exception?.message}")
                    resultLiveData.postValue(NetworkResult.Exception(exception ?: Exception("Unknown error")))

                }
            }

        return resultLiveData
    }
}
