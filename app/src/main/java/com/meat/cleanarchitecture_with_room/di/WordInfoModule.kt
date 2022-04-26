package com.meat.cleanarchitecture_with_room.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.meat.cleanarchitecture_with_room.core.util.Constant
import com.meat.cleanarchitecture_with_room.data.remote.api.ApiService
import com.meat.cleanarchitecture_with_room.data.remote.local.WordInfoDao
import com.meat.cleanarchitecture_with_room.data.remote.local.WordInfoDatabase
import com.meat.cleanarchitecture_with_room.data.repository.WordInfoRepositoryImpl
import com.meat.cleanarchitecture_with_room.data.util.GsonParser
import com.meat.cleanarchitecture_with_room.domain.repository.WordInfoRepository
import com.meat.cleanarchitecture_with_room.domain.use_case.getWordInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository):getWordInfoUseCase
    {
        return getWordInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(db: WordInfoDatabase,apiService: ApiService):WordInfoRepository{
        return WordInfoRepositoryImpl(apiService,db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app:Application):WordInfoDatabase{
        return Room.databaseBuilder(
            app,WordInfoDatabase::class.java
        ,"Word_db"
        ).addTypeConverter(GsonParser(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi():ApiService{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}