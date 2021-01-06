package domain.repository

import domain.model.Notification
import domain.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<Notification, Long>

interface TopicRepository : JpaRepository<Topic, Long>{
    fun findByTopic(topic: String): Topic?
}