package com.example.faizaltask1.network.repository

import android.util.Log
import com.example.faizaltask1.network.model.ApiServiceClass
import com.example.faizaltask1.network.model.Resource
import com.foreverinlove.network.model.reqBody
import com.example.faizaltask1.network.response.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File
import java.util.HashMap
import javax.inject.Inject


class DefaultMainRepository @Inject constructor(
    private val apiService: ApiServiceClass
) : MainRepository {

    val clientSecret =
        "NPaKyJ6L786p4R4dA22FJvIVzLvUhEty26ehPHwx2xKPEH7Bj4KkT2dzIyeSrBd5"
    //Api chalu hoy screen chnage thy tyare aavta toeast mate
    private val requestedWith = "XMLHttpRequest"

    private fun <T> handleException(e: Exception): Resource<T> {
        println("kanyeWestApi $e")
        return if (e.toString() == "java.net.SocketTimeoutException: timeout") {
            Resource.Error("Weak internet connection. Try again later.")
        } else if (e.toString().contains("kotlinx.coroutines.JobCancellationException")) {
            Resource.Error("")
        } else if (e.toString().contains("Expected BEGIN_ARRAY but was BEGIN_OBJECT")) {
            Resource.Error("")
        } else {
            Resource.Error("An $e occurred")
        }
    }

    override suspend fun getSendEmailOtp(email: String): Resource<SendOtpResponse> {
        return try {
            val response = apiService.getSendEmailOtp(
                clientSecret, email
            )
            if (response.isSuccessful) {
                Log.d("TAG", "getZodiacList: " + 27)
                Resource.Success(response.body(), "")
            } else {
                Log.d("TAG", "getZodiacList: " + 30)
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message)
        }
    }

    override suspend fun readMessage(
        currantId: String,
        otherId: String
    ): Resource<String> {
        return try {

            val response = apiService.readMessage(
                clientSecret, currantId, otherId
            )
            if (response.isSuccessful) {
                Log.d("TAG", "getZodiacList: " + 27)
                Resource.Success(response.body(), "")
            } else {
                Log.d("TAG", "getZodiacList: " + 30)
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message)
        }
    }


    override suspend fun getChinesZodiacList(): Resource<ChinesZodicResponse> {
        return try {

            val parts: MutableMap<String, RequestBody> = HashMap()

            parts["email"] = "".reqBody()
            val response = apiService.getChinesZodiacList(
                clientSecret, parts
            )
            if (response.isSuccessful) {
                Log.d("TAG", "getZodiacList: " + 368)
                Resource.Success(response.body(), "")
            } else {
                Log.d("TAG", "getZodiacList: " + 371)
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message)
        }
    }


}