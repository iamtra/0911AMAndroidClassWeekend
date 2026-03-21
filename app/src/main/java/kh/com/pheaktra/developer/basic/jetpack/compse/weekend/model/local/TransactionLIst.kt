package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.local

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.TransactionModel

val transactionList: List<TransactionModel> = listOf(
    TransactionModel(
        transactionId = "TXN202602210001",
        transactionAmount = 120.50,
        currency = "USD",
        senderName = "Buon Pheaktra",
        senderAccountNo = "ACC100001",
        receiverName = "Amazon",
        receiverAccountNo = "MER0001",
        transactionType = "",
        transactionStatus = "",
        transactionDate = "2026-02-21T09:10:00",
        referenceNo = "REF-AMZ-001",
        remark = "Online shopping",
        feeAmount = 1.25
    ),
    TransactionModel(
        transactionId = "TXN202602210002",
        transactionAmount = 250.00,
        currency = "KHR",
        senderName = "Buon Pheaktra",
        senderAccountNo = "ACC100001",
        receiverName = "Electricity Authority",
        receiverAccountNo = "BILL1002",
        transactionType = "",
        transactionStatus = "",
        transactionDate = "2026-02-20T18:45:00",
        referenceNo = "REF-ELEC-002",
        remark = "Electric bill",
        feeAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN202602210003",
        transactionAmount = 75.00,
        currency = "USD",
        senderName = "Buon Pheaktra",
        senderAccountNo = "ACC100001",
        receiverName = "Jane Smith",
        receiverAccountNo = "ACC200002",
        transactionType = "",
        transactionStatus = "",
        transactionDate = "2026-02-21T11:30:00",
        referenceNo = "REF-TRF-003",
        remark = "Lunch refund",
        feeAmount = 0.50
    ),
    TransactionModel(
        transactionId = "TXN202602210004",
        transactionAmount = 500.00,
        currency = "USD",
        senderName = "Company Payroll",
        senderAccountNo = "ACC-PAYROLL",
        receiverName = "Buon Pheaktra",
        receiverAccountNo = "ACC100001",
        transactionType = "",
        transactionStatus = "",
        transactionDate = "2026-02-19T08:00:00",
        referenceNo = "REF-SALARY-004",
        remark = "Monthly salary",
        feeAmount = 0.0
    ),
    TransactionModel(
        transactionId = "TXN202602210005",
        transactionAmount = 100.00,
        currency = "USD",
        senderName = "Buon Pheaktra",
        senderAccountNo = "ACC100001",
        receiverName = "ABA ATM",
        receiverAccountNo = "ATM-ABA-01",
        transactionType = "",
        transactionStatus = "",
        transactionDate = "2026-02-18T14:20:00",
        referenceNo = "REF-ATM-005",
        remark = "Insufficient balance",
        feeAmount = 2.00
    )
)