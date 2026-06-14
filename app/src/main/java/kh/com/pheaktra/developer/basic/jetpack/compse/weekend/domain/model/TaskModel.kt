package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.ValueYN
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.local.entity.Task
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.isNo
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.isYes
import kotlinx.serialization.Serializable

@Serializable
data class TaskModel(
    val taskId: Long,
    val taskName: String,
    val taskDescription: String,
    val taskCompletedYN: ValueYN
)

fun TaskModel.isCompleted() : Boolean {
    return this.taskCompletedYN.value.isYes()
}

fun TaskModel.incompleted() : Boolean {
    return this.taskCompletedYN.value.isNo()
}

fun TaskModel.toTask() : Task {
    return Task(
        taskId = this.taskId,
        taskName = this.taskName,
        taskDescription = this.taskDescription,
        taskCompleted = this.taskCompletedYN.value
    )
}