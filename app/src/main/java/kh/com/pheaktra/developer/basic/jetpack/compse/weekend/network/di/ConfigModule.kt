package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.EnvironmentConfig
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.impl.EnvironmentConfigImpl

@Module
@InstallIn(SingletonComponent::class)
object ConfigModule {

    @Provides
    @Singleton
    fun provideEnvironmentConfig(): EnvironmentConfig {
        return EnvironmentConfigImpl()
    }
}