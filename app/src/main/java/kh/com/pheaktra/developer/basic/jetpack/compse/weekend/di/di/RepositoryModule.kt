package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.imp.TaskRepositoryImpl
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.imp.UserRepositoryImpl
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.TaskRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository
}