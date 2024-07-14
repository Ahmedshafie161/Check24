package com.check.database


interface SharedPrefConst {
    val keyValue: String
}

object sharedPreferencesName : SharedPrefConst {
    override val keyValue: String = "main_sharedpreference_name"
}

object sharedPreferenceLanguage : SharedPrefConst {
    override val keyValue: String = "language"
}

object sharedPreferenceToken : SharedPrefConst {
    override val keyValue: String = "token"
}
object sharedPreferenceNameSpace : SharedPrefConst {
    override val keyValue: String = "NameSpace"
}

object sharedPreferenceUserData : SharedPrefConst {
    override val keyValue: String = "userData"
}

object sharedPreferenceFcmToken : SharedPrefConst {
    override val keyValue: String = "fcmToken"
}


object CommonSharedPrefConst {

    //Shared Preference
    var sharedPreferencesName = "main_sharedpreference_name"
    var sharedPreference_language = "language"
    var sharedPreference_token = "token"
    var sharedPreference_user_data = "userData"
    var sharedPreference_fcm_token = "fcmToken"

}
