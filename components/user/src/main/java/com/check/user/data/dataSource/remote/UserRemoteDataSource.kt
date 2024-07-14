package com.check.user.data.dataSource.remote

import com.check.network.grpc.GreeterRCP
import javax.inject.Inject


sealed interface CredentialKey {
    val value: String
    val type:String

    data class Email(override val value: String) : CredentialKey {
        override val type = "Email"
        fun isEmailValidated() = android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }

    data class SMS(override val value: String) : CredentialKey {
        override val type = "SMS"
        fun isValidPhoneNumber(phoneNumber: String) =
            android.util.Patterns.PHONE.matcher(phoneNumber).matches()
    }
}

class UserRemoteDataSource @Inject constructor(private val greeterRCP: GreeterRCP){

}
