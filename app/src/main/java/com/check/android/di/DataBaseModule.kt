package com.check.android.di

import android.content.Context
import android.content.SharedPreferences
import com.check.database.SharedPrefersManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("main_sharedpreference", 0)

    @Singleton
    @Provides
    fun provideSharedPrefersManager(sharedPreferences: SharedPreferences): SharedPrefersManager =
        SharedPrefersManager(sharedPreferences)
/*
    @Provides
    @Singleton
    fun provideEncryptedSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        return EncryptedSharedPreferences.create(
            "my_secure_prefs",
            "my_keyset_alias",
            applicationContext,
            MasterKeys.AES256_GCM_SPEC
        )
    }
*/
}