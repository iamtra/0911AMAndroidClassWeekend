package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.TableName
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM ${TableName.TASK}")
    suspend fun getTaskLists(): List<Task>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createTask(task: Task): Long

    @Update
    suspend fun updateTask(task: Task): Int

    @Query("DELETE FROM ${TableName.TASK} WHERE id = :taskId")
    suspend fun deleteTask(taskId: String): Int

    @Query("SELECT * FROM ${TableName.TASK} WHERE id = :taskId LIMIT 1")
    suspend fun getTaskById(taskId: String): Task?

    @Query("""
        SELECT * FROM ${TableName.TASK}
        WHERE task_name LIKE '%' || :title || '%'
    """)
    suspend fun getTasksByTitle(title: String): List<Task>

    @Query("""
        SELECT * FROM ${TableName.TASK}
        WHERE task_completed = :status
    """)
    suspend fun getTasksByStatus(status: String): List<Task>
}