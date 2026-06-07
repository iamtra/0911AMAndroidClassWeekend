package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.imp

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.dao.TaskDao
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity.toTaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity.toTaskModelList
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.toTask
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun getTasks(): List<TaskModel> {
        return taskDao.getTaskLists().toTaskModelList()
    }

    override suspend fun createTask(task: TaskModel): TaskModel {
        val taskId = taskDao.createTask(task.toTask())
        return task.copy(taskId = taskId)
    }

    override suspend fun updateTask(task: TaskModel): TaskModel {
        taskDao.updateTask(task.toTask())
        return task
    }

    override suspend fun deleteTask(taskId: String): TaskModel {
        val task = taskDao.getTaskById(taskId) ?: throw Exception("Task not found")
        taskDao.deleteTask(taskId)
        return task.toTaskModel()
    }

    override suspend fun getTaskById(taskId: String): TaskModel? {
        return taskDao.getTaskById(taskId)?.toTaskModel()
    }

    override suspend fun getTasksByTitle(title: String): List<TaskModel> {
        return taskDao.getTasksByTitle(title).toTaskModelList()
    }

    override suspend fun getTasksByStatus(status: String): List<TaskModel> {
        return taskDao.getTasksByStatus(status).toTaskModelList()
    }
}