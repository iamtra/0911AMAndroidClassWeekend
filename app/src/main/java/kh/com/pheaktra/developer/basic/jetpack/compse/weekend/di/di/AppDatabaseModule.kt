package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.AppDatabase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.dao.TaskDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(
        database: AppDatabase,
    ): TaskDao {
        return database.userDao()
    }
}