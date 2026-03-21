package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model

data class TransactionModel(
    val transactionId: String,
    val transactionAmount: Double,
    val currency: String,

    // Sender
    val senderName: String,
    val senderAccountNo: String,

    // Receiver
    val receiverName: String,
    val receiverAccountNo: String,

    // Meta
    val transactionType: String, // Bakong, fund transfer, International fund  transfer...
    val transactionStatus: String, // Pending, Failed, Success
    val transactionDate: String,        // e.g. 2026-02-21T10:30:00
    val referenceNo: String,

    // Optional
    val remark: String? = null,
    val feeAmount: Double = 0.0
)
