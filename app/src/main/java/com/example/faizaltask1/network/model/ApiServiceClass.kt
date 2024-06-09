package com.example.faizaltask1.network.model


import com.example.faizaltask1.network.response.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


const val tokenKey = "Api-Key"

interface ApiServiceClass {
    //file jati hoyne tyare multipart key word aave

    @FormUrlEncoded
    @POST("register_otp")
    suspend fun getSendEmailOtp(
        @Header(tokenKey) token: String,
        @Field("email") email: String,
    ): Response<SendOtpResponse>


    @JvmSuppressWildcards
    @FormUrlEncoded
    @POST("read_message")
    suspend fun readMessage(
        @Header(tokenKey) token: String,
        @Field("user_id") currantId: String,
        @Field("friend_id") otherId: String
    ): Response<String>

    @Multipart
    @JvmSuppressWildcards
    @POST("get_zodiac_list")
    suspend fun getChinesZodiacList(
        @Header(tokenKey) token: String,
        @PartMap params: Map<String, RequestBody>,
    ): Response<ChinesZodicResponse>

}
