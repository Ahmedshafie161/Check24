package com.check.database

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject


class SharedPrefersManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveToken(token: String?) {
        sharedPreferences.edit().apply {
            putString(sharedPreferenceToken.keyValue, token)
        }.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(sharedPreferenceToken.keyValue, null)
    }

    fun saveNameSpace(nameSpace: String?) {
        sharedPreferences.edit().apply {
            putString(sharedPreferenceNameSpace.keyValue, nameSpace)
        }.apply()
    }

    fun getNameSpace(): String? {
        return sharedPreferences.getString(sharedPreferenceNameSpace.keyValue, null)
    }

    fun saveObj(key:SharedPrefConst,obj:Any){
        sharedPreferences.edit().apply { putString(key.keyValue, Gson().toJson(obj)) }.apply()
    }
    fun <T>getObj(key: SharedPrefConst):T{
        return Gson().fromJson(
            sharedPreferences.getString(key.keyValue , null),object : TypeToken<T>(){}.type
        )
    }

    fun logout() {
        sharedPreferences.edit().remove(sharedPreferencesName.keyValue).apply()
        sharedPreferences.edit().remove(sharedPreferenceFcmToken.keyValue).apply()
    }

    fun isUserLongedIn(): Boolean {
        return sharedPreferences.contains(sharedPreferenceUserData.keyValue)
    }

    companion object {
        const val LANGUAGE_AR = "ar"
        const val LANGUAGE_EN = "en"
    }

}
