package dto

import org.apache.http.HttpStatus

data class SendResponse(
    val result: HttpStatus,
    val reason: String,
    val messageId: String
)