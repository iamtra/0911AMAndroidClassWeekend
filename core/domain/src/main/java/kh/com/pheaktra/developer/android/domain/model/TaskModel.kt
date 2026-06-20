package kh.com.pheaktra.developer.android.domain.model

import kh.com.pheaktra.developer.android.util.common.ValueYN
import kh.com.pheaktra.developer.android.util.common.extension.isNo
import kh.com.pheaktra.developer.android.util.common.extension.isYes
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