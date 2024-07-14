package com.check.android.di

import android.content.Context
import com.check.android.CheckApplication
import com.check.ui.base.GlobalState
import com.check.ui.base.IGlobalState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): CheckApplication {
        return app as CheckApplication
    }

    @Singleton
    @Provides
    fun provideGlobalState(): IGlobalState {
        return GlobalState()
    }

}
