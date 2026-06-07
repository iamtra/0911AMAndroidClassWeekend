package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.TableName
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.toValueYN

@Entity(TableName.TASK)
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val taskId: Long,
    @ColumnInfo("task_name") val taskName: String,
    @ColumnInfo("task_description") val taskDescription: String,
    @ColumnInfo("task_completed") val taskCompleted: String
)

fun Task.toTaskModel() : TaskModel {
    return TaskModel(
        taskId = this.taskId,
        taskName = taskName,
        taskDescription = taskDescription,
        taskCompletedYN = this.taskCompleted.toValueYN()
    )
}

fun List<Task>.toTaskModelList() : List<TaskModel> {
    return this.map { it.toTaskModel() }
}