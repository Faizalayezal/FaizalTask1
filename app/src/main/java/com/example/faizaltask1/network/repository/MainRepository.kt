package com.example.faizaltask1.network.repository


import com.example.faizaltask1.network.model.Resource
import com.example.faizaltask1.network.response.*

interface MainRepository {


    suspend fun getSendEmailOtp(
        email: String
    ): Resource<SendOtpResponse>

    suspend fun readMessage(
        currantId: String, otherId: String
    ): Resource<String>

    suspend fun getChinesZodiacList(
    ): Resource<ChinesZodicResponse>
}
