package com.example.breesmobileapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breesmobileapp.data.remote.api.DataState
import com.example.breesmobileapp.data.remote.api.NetworkResult
import com.example.breesmobileapp.data.remote.api.convertToDataState
import com.example.breesmobileapp.data.remote.model.User
import com.example.breesmobileapp.data.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class AuthViewModel @Inject constructor(private val firebaseRepository: FirebaseRepository) :
    ViewModel() {

    private val _signInResult: MutableLiveData<DataState<User>> = MutableLiveData()
    val signInResult: LiveData<DataState<User>> = _signInResult

    private val _signUpResult: MutableLiveData<DataState<User>> = MutableLiveData()
    val signUpResult: LiveData<DataState<User>> = _signUpResult

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _signInResult.postValue(DataState.Init)
            val result = withContext(Dispatchers.IO) {
                firebaseRepository.signIn(email, password)
            }

            _signInResult.postValue(result.value?.convertToDataState())
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            _signUpResult.postValue(DataState.Init)
            try {

                val result = suspendCoroutine<NetworkResult<User>> { continuation ->
                    firebaseRepository.signUp(email, password)
                        .observeForever { networkResult ->
                            continuation.resume(networkResult)
                        }
                }
                _signUpResult.postValue(result.convertToDataState())
            } catch (e: Exception) {
                // Handle exceptions here
                _signUpResult.postValue(DataState.Failure("An error occurred"))
            }
        }

    }


}
