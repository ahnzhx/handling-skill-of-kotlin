package service

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification

import domain.model.Topic
import domain.repository.NotificationRepository
import dto.SendResponse
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service

import util.LoggerDelegate
import javax.transaction.Transactional

@Service
@Transactional
class MessageProvider (
    val notificationRepository: NotificationRepository
    ){
    private val log by LoggerDelegate()

    fun send(topic: Topic, message: String): SendResponse {
        val firebaseMessage = buildMessage(message, topic.topic)

        val messageId = FirebaseMessaging.getInstance()
            .send(firebaseMessage)

        log.info("response from firebase = $messageId")

        notificationRepository.save(
            domain.model.Notification(message, topic)
        )
        return SendResponse(HttpStatus.OK, "success", messageId)
    }



    private fun buildMessage(
        message: String,
        topic: String
    ): Message{
        val notification: Notification = Notification.builder()
            .setBody(message)
            .build()

        return Message.builder()
            .setTopic(topic)
            .setNotification(notification).build()

    }

}