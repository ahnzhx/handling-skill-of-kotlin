package com.study.notification.domain.repository

import com.study.notification.domain.model.Notification
import com.study.notification.domain.model.Topic
import com.study.notification.dto.TopicStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@DataJpaTest(showSql=true)
class NotificationRepositoryTest @Autowired constructor(
    val notificationRepository: NotificationRepository,
    val topicRepository: TopicRepository
){

    @PersistenceContext
    lateinit var entitymanager: EntityManager

    @Test
    @Transactional
    internal fun `find by id test for notification repository`(){
        //given
        val topic = Topic("news", TopicStatus.ACTIVE)
        val message = "test message"
        val notification = Notification(message, topic)
        notificationRepository.save(notification)
        entitymanager.flush()

        //when
        val find = notificationRepository.findById(1)
        val findTopic = topicRepository.findById(4)

        println(find.get())

        // then
        assertThat(find.get()).isNotNull
        assertThat(find.get().id).isEqualTo(1)
        assertThat(find.get().message).isEqualTo(message)

        assertThat(findTopic.get()).isNotNull
        assertThat(findTopic.get().id).isEqualTo(4)
        assertThat(findTopic.get().topic).isEqualTo("news")
        assertThat(findTopic.get().status).isEqualTo(TopicStatus.ACTIVE)

    }
}