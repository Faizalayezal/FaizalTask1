package com.example.faizaltask1.network.response


data class ChinesZodicResponse(
    val status: Boolean?,
    val message: String?,
    val data: ArrayList<ChinesZodicDataResponse>?,
): java.io.Serializable

data class ChinesZodicDataResponse(

    val id: Int?,
    val title: String?,
    val icon: String?,
    val thumbnail: String?,
    val chinese_sign: String?,
    val lucky_numbers: String?,
    val unlucky_numbers: String?,
    val lucky_colors: String?,
    val unlucky_colors: String?,
    val year_of_birth: String?,
    val description: String?,
    val introduction: String?,
    val advantage: String?,
    val disadvantage: String?,
    val updated_at: String?,
    val created_at: String?,
): java.io.Serializable
