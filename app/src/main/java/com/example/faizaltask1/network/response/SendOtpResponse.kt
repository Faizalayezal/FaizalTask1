package com.example.faizaltask1.network.response

//@SerializedName("body")
data class SendOtpResponse(
    val status: Boolean?,
    val otp: Int?,
    val message: String?,
    val user_id: Int?,
):java.io.Serializable