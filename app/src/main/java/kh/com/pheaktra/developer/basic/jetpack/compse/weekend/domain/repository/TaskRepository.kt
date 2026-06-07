package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel

interface TaskRepository {
    suspend fun getTasks(): List<TaskModel>

    suspend fun createTask(task: TaskModel): TaskModel

    suspend fun updateTask(task: TaskModel): TaskModel

    suspend fun deleteTask(taskId: String): TaskModel

    suspend fun getTaskById(taskId: String): TaskModel?

    suspend fun getTasksByTitle(title: String): List<TaskModel>

    suspend fun getTasksByStatus(status: String): List<TaskModel>
}