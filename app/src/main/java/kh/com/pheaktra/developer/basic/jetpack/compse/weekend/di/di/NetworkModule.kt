package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.remote.ApiService
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.remote.RetrofitClient


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitClient.apiService
    }
}