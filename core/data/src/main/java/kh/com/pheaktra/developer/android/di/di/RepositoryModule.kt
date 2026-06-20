package kh.com.pheaktra.developer.android.di.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kh.com.pheaktra.developer.android.di.imp.TaskRepositoryImpl
import kh.com.pheaktra.developer.android.di.imp.UserRepositoryImpl
import kh.com.pheaktra.developer.android.domain.repository.TaskRepository
import kh.com.pheaktra.developer.android.domain.repository.UserRepository

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