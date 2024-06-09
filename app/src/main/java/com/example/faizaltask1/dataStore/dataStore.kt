package com.example.faizaltask1.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.faizaltask1.dataStore.response.TempUserDataObject
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_datastore")

//private const val TAG = "dataStore"
class DataStoreManager(val context: Context) {

    companion object {
        //user's all data
        val TEMP_PLAN_PURCHASED_ONCE = booleanPreferencesKey("TEMP_PLAN_PURCHASED_ONCE")
        val TEMP_LOGIN_OTP = stringPreferencesKey("TEMP_LOGIN_OTP")
        val TEMP_TOKEN_TYPE = stringPreferencesKey("TEMP_TOKEN_TYPE")
        val TEMP_SESSION_ID = stringPreferencesKey("TEMP_SESSION_ID")
        val TEMP_TOKEN = stringPreferencesKey("TEMP_TOKEN")
        val TEMP_USER_STATUS = stringPreferencesKey("TEMP_USER_STATUS")
        val TEMP_PHONE = stringPreferencesKey("TEMP_PHONE")
        val TEMP_FIRST_NAME = stringPreferencesKey("FIRST_NAME")
        val TEMP_ID = stringPreferencesKey("ID")
        val TEMP_LAST_NAME = stringPreferencesKey("LAST_NAME")
        val TEMP_DOB = stringPreferencesKey("DOB")
        val TEMP_AGE = stringPreferencesKey("AGE")
        val TEMP_EMAIL = stringPreferencesKey("EMAIL")
        val TEMP_EMAIL_VERIFIED = stringPreferencesKey("EMAIL_VERIFIED")
        val TEMP_GENDER = stringPreferencesKey("GENDER")
        val TEMP_INTEREST = stringPreferencesKey("INTEREST")
        val TEMP_JOB_TITLE = stringPreferencesKey("JOB_TITLE")
        val TEMP_LOGIN_TYPE = stringPreferencesKey("LOGIN_TYPE")
        val TEMP_OTP_EXPIRED_TIME = stringPreferencesKey("OTP_EXPIRED_TIME")
        val TEMP_ADDRESS = stringPreferencesKey("ADDRESS")
        val TEMP_LATITUDE = stringPreferencesKey("LATITUDE")
        val TEMP_LONGITUDE = stringPreferencesKey("LONGITUDE")
        val TEMP_HEIGHT = stringPreferencesKey("HEIGHT")
        val TEMP_IMAGE1 = stringPreferencesKey("IMAGE1")
        val TEMP_IMAGE2 = stringPreferencesKey("IMAGE2")
        val TEMP_IMAGE3 = stringPreferencesKey("IMAGE3")
        val TEMP_IMAGE4 = stringPreferencesKey("IMAGE4")
        val TEMP_IMAGE5 = stringPreferencesKey("IMAGE5")
        val TEMP_IMAGE6 = stringPreferencesKey("IMAGE6")
        val TEMP_IMAGE_ID1 = stringPreferencesKey("IMAGEID1")
        val TEMP_IMAGE_ID2 = stringPreferencesKey("IMAGEID2")
        val TEMP_IMAGE_ID3 = stringPreferencesKey("IMAGEID3")
        val TEMP_IMAGE_ID4 = stringPreferencesKey("IMAGEID4")
        val TEMP_IMAGE_ID5 = stringPreferencesKey("IMAGEID5")
        val TEMP_IMAGE_ID6 = stringPreferencesKey("IMAGEID6")
        val ABOUT = stringPreferencesKey("ABOUT")
        val TEMP_PROFILE_VIDEO = stringPreferencesKey("PROFILE_VIDEO")
        val TEMP_LAST_SEEN = stringPreferencesKey("LAST_SEEN")
        val TEMP_FCM_TOKEN = stringPreferencesKey("FCM_TOKEN")

        val TEMP_EDUCATION = stringPreferencesKey("EDUCATION")
        val TEMP_Looking_FOR = stringPreferencesKey("Looking_FOR")
        val TEMP_DIETARY_LIFESTYLE = stringPreferencesKey("DIETARY_LIFESTYLE")
        val TEMP_PETS = stringPreferencesKey("PETS")
        val TEMP_ARTS = stringPreferencesKey("ARTS")
        val TEMP_LANGUAGE = stringPreferencesKey("LANGUAGE")
        val TEMP_INTERESTS = stringPreferencesKey("INTERESTS")
        val TEMP_DRINK = stringPreferencesKey("DRINK")
        val TEMP_DRUGS = stringPreferencesKey("DRUGS")
        val TEMP_HOROSCOPE = stringPreferencesKey("HOROSCOPE")
        val TEMP_RELIGION = stringPreferencesKey("RELIGION")
        val TEMP_POLITICAL_LEANING = stringPreferencesKey("POLITICAL_LEANING")
        val TEMP_RELATIONSHIP_STATUS = stringPreferencesKey("RELATIONSHIP_STATUS")
        val TEMP_LIFE_STYLE = stringPreferencesKey("LIFE_STYLE")
        val TEMP_FIRST_DATE_ICE_BREAKER = stringPreferencesKey("FIRST_DATE_ICE_BREAKER")
        val TEMP_COVID_VACCINE = stringPreferencesKey("COVID_VACCINE")
        val TEMP_SMOKING = stringPreferencesKey("SMOKING")
        val TEMP_REGISTER_FLOW_STATUS = stringPreferencesKey("TEMP_REGISTER_FLOW_STATUS")

        val TEMP_POP = stringPreferencesKey("TEMP_POP")

        //   val TEMP_API_TOKEN=stringPreferencesKey("API_TOKEN")


        // FilterData
        val FILTER_DISTANCE_UNIT = stringPreferencesKey("FILTER_DISTANCE")
        val FILTER_MIN_AGE = stringPreferencesKey("FILTER_MIN_AGE")
        val FILTER_MAX_AGE = stringPreferencesKey("FILTER_MAX_AGE")
        val FILTER_LAT = stringPreferencesKey("FILTER_LAT")
        val FILTER_LONG = stringPreferencesKey("FILTER_LONG")
        val FILTER_PAGE = stringPreferencesKey("FILTER_PAGE")
        val FILTER_PAGE_SIZE = stringPreferencesKey("FILTER_PAGE_SIZE")
        val FILTER_EDUCATION = stringPreferencesKey("FILTER_EDUCATION")
        val FILTER_MIN_DISTANCE = stringPreferencesKey("FILTER_MIN_DISTANCE")
        val FILTER_MAX_DISTANCE = stringPreferencesKey("FILTER_MAX_DISTANCE")
        val FILTER_ARTS = stringPreferencesKey("FILTER_ARTS")
        val FILTER_VACCINE = stringPreferencesKey("FILTER_VACCINE")
        val FILTER_DIETRY_LIFE_STYLE = stringPreferencesKey("FILTER_DIETRY_LIFE_STYLE")
        val FILTER_DRINK = stringPreferencesKey("FILTER_DRINK")
        val FILTER_DRUG = stringPreferencesKey("FILTER_DRUG")
        val FILTER_ICE_BREAKER = stringPreferencesKey("FILTER_ICE_BREAKER")
        val FILTER_HOROSCOPE = stringPreferencesKey("FILTER_HOROSCOPE")
        val FILTER_INTEREST = stringPreferencesKey("FILTER_INTEREST")
        val FILTER_LANGUAGE = stringPreferencesKey("FILTER_LANGUAGE")
        val FILTER_LOOKING_FOR = stringPreferencesKey("FILTER_LOOKING_FOR")
        val FILTER_PETS = stringPreferencesKey("FILTER_PETS")
        val FILTER_POLITICAL = stringPreferencesKey("FILTER_POLITICAL")
        val FILTER_RELATION_STATUS = stringPreferencesKey("FILTER_RELATION_STATUS")
        val FILTER_RELIGION = stringPreferencesKey("FILTER_RELIGION")
        val FILTER_SMOKING = stringPreferencesKey("FILTER_SMOKING")
        val FILTER_ISAPPLAY_FILTER = stringPreferencesKey("FILTER_ISAPPLAY_FILTER")
        val FILTER_MIX_HEIGHT = stringPreferencesKey("FILTER_MIX_HEIGHT")
        val FILTER_MAX_HEIGHT = stringPreferencesKey("FILTER_MAX_HEIGHT")
        val FILTER_HOBBIES = stringPreferencesKey("FILTER_HOBBIES")
        val FILTER_ADDRESS = stringPreferencesKey("FILTER_ADDRESS")


    }

}

suspend fun Context.dataStoreSetUserData(data: TempUserDataObject) {

    //  Log.d(TAG, "dataStoreSetUserData: >>"+data.token)

    dataStore.edit {
        it[DataStoreManager.TEMP_PLAN_PURCHASED_ONCE] = data.is_once_purchased
        if (data.login_otp != "") it[DataStoreManager.TEMP_LOGIN_OTP] = data.login_otp
        if (data.token_type != "") it[DataStoreManager.TEMP_TOKEN_TYPE] = data.token_type
        if (data.session_id != "") it[DataStoreManager.TEMP_SESSION_ID] = data.session_id
        if (data.token != "") it[DataStoreManager.TEMP_TOKEN] = data.token
        if (data.userStatus != "") it[DataStoreManager.TEMP_USER_STATUS] = data.userStatus
        if (data.phone != "") it[DataStoreManager.TEMP_PHONE] = data.phone
        if (data.first_name != "") it[DataStoreManager.TEMP_FIRST_NAME] = data.first_name
        if (data.id != "") it[DataStoreManager.TEMP_ID] = data.id
        if (data.last_name != "") it[DataStoreManager.TEMP_LAST_NAME] = data.last_name
        if (data.dob != "") it[DataStoreManager.TEMP_DOB] = data.dob
        if (data.age != "") it[DataStoreManager.TEMP_AGE] = data.age
        if (data.email != "") it[DataStoreManager.TEMP_EMAIL] = data.email
        if (data.emailVerified != "") it[DataStoreManager.TEMP_EMAIL_VERIFIED] = data.emailVerified
        if (data.gender != "") it[DataStoreManager.TEMP_GENDER] = data.gender
        if (data.intrested != "") it[DataStoreManager.TEMP_INTEREST] = data.intrested
        if (data.job_title != "") it[DataStoreManager.TEMP_JOB_TITLE] = data.job_title
        if (data.login_type != "") it[DataStoreManager.TEMP_LOGIN_TYPE] = data.login_type
        if (data.otp_expird_time != "") it[DataStoreManager.TEMP_OTP_EXPIRED_TIME] =
            data.otp_expird_time
        if (data.address != "") it[DataStoreManager.TEMP_ADDRESS] = data.address
        if (data.latitude != "") it[DataStoreManager.TEMP_LATITUDE] = data.latitude
        if (data.longitude != "") it[DataStoreManager.TEMP_LONGITUDE] = data.longitude
        if (data.height != "") it[DataStoreManager.TEMP_HEIGHT] = data.height
        it[DataStoreManager.TEMP_IMAGE1] = data.imageUrl1
        it[DataStoreManager.TEMP_IMAGE2] = data.imageUrl2
        it[DataStoreManager.TEMP_IMAGE3] = data.imageUrl3
        it[DataStoreManager.TEMP_IMAGE4] = data.imageUrl4
        it[DataStoreManager.TEMP_IMAGE5] = data.imageUrl5
        it[DataStoreManager.TEMP_IMAGE6] = data.imageUrl6
        it[DataStoreManager.TEMP_IMAGE_ID1] = data.imageId1
        it[DataStoreManager.TEMP_IMAGE_ID2] = data.imageId2
        it[DataStoreManager.TEMP_IMAGE_ID3] = data.imageId3
        it[DataStoreManager.TEMP_IMAGE_ID4] = data.imageId4
        it[DataStoreManager.TEMP_IMAGE_ID5] = data.imageId5
        it[DataStoreManager.TEMP_IMAGE_ID6] = data.imageId6
        if (data.about != "") it[DataStoreManager.ABOUT] = data.about
        if (data.profile_video != "") it[DataStoreManager.TEMP_PROFILE_VIDEO] = data.profile_video
        if (data.lastseen != "") it[DataStoreManager.TEMP_LAST_SEEN] = data.lastseen
        if (data.fcm_token != "") it[DataStoreManager.TEMP_FCM_TOKEN] = data.fcm_token



        if (data.ukeyeducation != "") it[DataStoreManager.TEMP_EDUCATION] = data.ukeyeducation
        if (data.ukeylooking_for != "") it[DataStoreManager.TEMP_Looking_FOR] = data.ukeylooking_for
        it[DataStoreManager.TEMP_DIETARY_LIFESTYLE] = data.ukeydietary_lifestyle
        it[DataStoreManager.TEMP_PETS] = data.ukeypets
        it[DataStoreManager.TEMP_ARTS] = data.ukeyarts
        if (data.ukeylanguage != "") it[DataStoreManager.TEMP_LANGUAGE] = data.ukeylanguage
        it[DataStoreManager.TEMP_INTERESTS] = data.ukeyinterests
        it[DataStoreManager.TEMP_DRINK] = data.ukeydrink
        it[DataStoreManager.TEMP_DRUGS] = data.ukeydrugs
        it[DataStoreManager.TEMP_HOROSCOPE] = data.ukeyhoroscope
        it[DataStoreManager.TEMP_RELIGION] = data.ukeyreligion
        it[DataStoreManager.TEMP_POLITICAL_LEANING] = data.ukeypolitical_leaning
        if (data.ukeyrelationship_status != "") it[DataStoreManager.TEMP_RELATIONSHIP_STATUS] =
            data.ukeyrelationship_status
        if (data.ukeylife_style != "") it[DataStoreManager.TEMP_LIFE_STYLE] = data.ukeylife_style
        it[DataStoreManager.TEMP_FIRST_DATE_ICE_BREAKER] = data.ukeyfirst_date_ice_breaker
        it[DataStoreManager.TEMP_COVID_VACCINE] = data.ukeycovid_vaccine
        it[DataStoreManager.TEMP_SMOKING] = data.ukeysmoking
    }
}

suspend fun Context.dataStoreSetGroupPopup(data: String) {
    dataStore.edit {
        it[DataStoreManager.TEMP_POP] = data
    }
}

fun Context.dataStoreGetGroupPopup() = dataStore.data.map {
    it[DataStoreManager.TEMP_POP] ?: ""
}

fun Context.dataStoreGetUserData() = dataStore.data.map {
    // Log.d("", "dataStoreGetUserData: "+it[DataStoreManager.TEMP_API_TOKEN])


    TempUserDataObject(
        is_once_purchased = it[DataStoreManager.TEMP_PLAN_PURCHASED_ONCE] ?: false,
        login_otp = it[DataStoreManager.TEMP_LOGIN_OTP] ?: "",
        token_type = it[DataStoreManager.TEMP_TOKEN_TYPE] ?: "",
        session_id = it[DataStoreManager.TEMP_SESSION_ID] ?: "",
        token = it[DataStoreManager.TEMP_TOKEN] ?: "",
        userStatus = it[DataStoreManager.TEMP_USER_STATUS] ?: "",
        phone = it[DataStoreManager.TEMP_PHONE] ?: "",
        id = it[DataStoreManager.TEMP_ID] ?: "",
        first_name = it[DataStoreManager.TEMP_FIRST_NAME] ?: "",
        last_name = it[DataStoreManager.TEMP_LAST_NAME] ?: "",
        dob = it[DataStoreManager.TEMP_DOB] ?: "",
        email = it[DataStoreManager.TEMP_EMAIL] ?: "",
        emailVerified = it[DataStoreManager.TEMP_EMAIL_VERIFIED] ?: "",
        age = it[DataStoreManager.TEMP_AGE] ?: "",
        gender = it[DataStoreManager.TEMP_GENDER] ?: "",
        intrested = it[DataStoreManager.TEMP_INTEREST] ?: "",
        job_title = it[DataStoreManager.TEMP_JOB_TITLE] ?: "",
        login_type = it[DataStoreManager.TEMP_LOGIN_TYPE] ?: "",
        otp_expird_time = it[DataStoreManager.TEMP_OTP_EXPIRED_TIME] ?: "",
        address = it[DataStoreManager.TEMP_ADDRESS] ?: "",
        latitude = it[DataStoreManager.TEMP_LATITUDE] ?: "",
        longitude = it[DataStoreManager.TEMP_LONGITUDE] ?: "",
        height = it[DataStoreManager.TEMP_HEIGHT] ?: "",
        imageUrl1 = it[DataStoreManager.TEMP_IMAGE1] ?: "",
        imageUrl2 = it[DataStoreManager.TEMP_IMAGE2] ?: "",
        imageUrl3 = it[DataStoreManager.TEMP_IMAGE3] ?: "",
        imageUrl4 = it[DataStoreManager.TEMP_IMAGE4] ?: "",
        imageUrl5 = it[DataStoreManager.TEMP_IMAGE5] ?: "",
        imageUrl6 = it[DataStoreManager.TEMP_IMAGE6] ?: "",
        imageId1 = it[DataStoreManager.TEMP_IMAGE_ID1] ?: "",
        imageId2 = it[DataStoreManager.TEMP_IMAGE_ID2] ?: "",
        imageId3 = it[DataStoreManager.TEMP_IMAGE_ID3] ?: "",
        imageId4 = it[DataStoreManager.TEMP_IMAGE_ID4] ?: "",
        imageId5 = it[DataStoreManager.TEMP_IMAGE_ID5] ?: "",
        imageId6 = it[DataStoreManager.TEMP_IMAGE_ID6] ?: "",
        about = it[DataStoreManager.ABOUT] ?: "",
        profile_video = it[DataStoreManager.TEMP_PROFILE_VIDEO] ?: "",
        lastseen = it[DataStoreManager.TEMP_LAST_NAME] ?: "",
        fcm_token = it[DataStoreManager.TEMP_FCM_TOKEN] ?: "",

        ukeyeducation = it[DataStoreManager.TEMP_EDUCATION] ?: "",
        ukeylanguage = it[DataStoreManager.TEMP_LANGUAGE] ?: "",
        ukeypolitical_leaning = it[DataStoreManager.TEMP_POLITICAL_LEANING] ?: "",
        ukeylooking_for = it[DataStoreManager.TEMP_Looking_FOR] ?: "",
        ukeydietary_lifestyle = it[DataStoreManager.TEMP_DIETARY_LIFESTYLE] ?: "",
        ukeypets = it[DataStoreManager.TEMP_PETS] ?: "",
        ukeyarts = it[DataStoreManager.TEMP_ARTS] ?: "",
        ukeyinterests = it[DataStoreManager.TEMP_INTERESTS] ?: "",
        ukeydrink = it[DataStoreManager.TEMP_DRINK] ?: "",
        ukeydrugs = it[DataStoreManager.TEMP_DRUGS] ?: "",
        ukeyhoroscope = it[DataStoreManager.TEMP_HOROSCOPE] ?: "",
        ukeyreligion = it[DataStoreManager.TEMP_RELIGION] ?: "",
        ukeyrelationship_status = it[DataStoreManager.TEMP_RELATIONSHIP_STATUS] ?: "",
        ukeylife_style = it[DataStoreManager.TEMP_LIFE_STYLE] ?: "",
        ukeyfirst_date_ice_breaker = it[DataStoreManager.TEMP_FIRST_DATE_ICE_BREAKER] ?: "",
        ukeycovid_vaccine = it[DataStoreManager.TEMP_COVID_VACCINE] ?: "",
        ukeysmoking = it[DataStoreManager.TEMP_SMOKING] ?: "",
    )
}

suspend fun Context.dataStoreClearAll() {
    dataStore.edit {
        it.clear()

    }
}



