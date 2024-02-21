package com.app.rediexpress.di


import android.app.Application
import com.app.rediexpress.data.manger.LocalUserMangerImpl
import com.app.rediexpress.domain.manger.LocalUserManger
import com.app.rediexpress.domain.usecases.AppEntryUseCases
import com.app.rediexpress.domain.usecases.ReadAppEntry
import com.app.rediexpress.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}