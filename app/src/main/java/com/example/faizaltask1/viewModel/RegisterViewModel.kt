package com.example.faizaltask1.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faizaltask1.dataStore.dataStoreGetUserData
import com.example.faizaltask1.dataStore.dataStoreSetUserData
import com.example.faizaltask1.network.model.Resource
import com.example.faizaltask1.network.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "RegisterViewModel"


@HiltViewModel
class RegisterViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {

/*
 private val _podcasts = MutableStateFlow(UserDataObject())
    var podcastsLive: StateFlow<UserDataObject> = _podcasts


    fun updateUserData(getNewObj: UserDataObject?) = viewModelScope.launch {
        getNewObj?.let {
            _podcasts.value = getNewObj
        }
        Log.d(
            TAG,
            "saveLocally: updateUserData>>${_podcasts.value.height}>>${_podcasts.value.address}>>${_podcasts.value.longitude}"
        )
    }

*/

    fun sendEmailOtp(
        context: Context,
        email: String,
        pwd:String,
        onComplete: (status: Boolean, msg: String, otp: String) -> Unit
    ) =
        viewModelScope.launch {
            when (val data = repository.getSendEmailOtp(email)) {
                is Resource.Error -> {
                    onComplete.invoke(data.data?.status?:true, data.data?.message ?: "", "")
                }

                is Resource.Success -> {
                                        val userObj = context.dataStoreGetUserData().firstOrNull() ?: return@launch
                    context.dataStoreSetUserData(userObj.copy(email = email).copy(address = "dffd"))
                    if (data.data?.status == true) {
                        onComplete.invoke(data.data.status, data.data.message ?: "", data.data.otp.toString())
                    } else {
                        onComplete.invoke(data.data?.status?:true, data.data?.message ?: "", "")
                    }
                }
            }
        }
}



