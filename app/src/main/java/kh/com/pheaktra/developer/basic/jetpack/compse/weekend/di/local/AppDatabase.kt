package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.dao.TaskDao
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): TaskDao
}