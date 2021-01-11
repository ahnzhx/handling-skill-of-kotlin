package com.study.notification.domain.repository

import com.study.notification.domain.model.Notification
import com.study.notification.domain.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<Notification, Long>

interface TopicRepository : JpaRepository<Topic, Long>{
    fun findByTopic(topic: String): Topic?
}