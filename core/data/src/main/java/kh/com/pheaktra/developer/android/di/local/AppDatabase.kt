package kh.com.pheaktra.developer.android.di.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kh.com.pheaktra.developer.android.di.local.dao.TaskDao
import kh.com.pheaktra.developer.android.di.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): TaskDao
}