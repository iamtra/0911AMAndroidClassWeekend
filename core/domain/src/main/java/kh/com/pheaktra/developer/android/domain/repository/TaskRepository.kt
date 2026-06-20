package kh.com.pheaktra.developer.android.domain.repository

import kh.com.pheaktra.developer.android.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<TaskModel>>

    suspend fun createTask(task: TaskModel): TaskModel

    suspend fun updateTask(task: TaskModel): TaskModel

    suspend fun deleteTask(taskId: Long): TaskModel

    suspend fun getTaskById(taskId: Long): TaskModel?

    suspend fun getTasksByTitle(title: String): List<TaskModel>

    suspend fun getTasksByStatus(status: String): List<TaskModel>
}