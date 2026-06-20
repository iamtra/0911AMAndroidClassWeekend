package kh.com.pheaktra.developer.android.di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kh.com.pheaktra.developer.android.network.ApiService
import kh.com.pheaktra.developer.android.network.RetrofitClient


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitClient.apiService
    }
}