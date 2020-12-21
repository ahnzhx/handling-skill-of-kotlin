package dto

import org.springframework.http.HttpStatus

data class SendResponse(
    val result: HttpStatus,
    val reason: String,
    val messageId: String
)