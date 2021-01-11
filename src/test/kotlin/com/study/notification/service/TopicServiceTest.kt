package com.study.notification.service

import com.study.notification.domain.model.Topic
import com.study.notification.domain.repository.TopicRepository
import com.study.notification.dto.TopicStatus
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TopicServiceTest{
    private val topicRepository =  spyk<TopicRepository>()
    private val topicService = TopicService(topicRepository)

    @Test
    fun `topic status test`(){
        val active = TopicStatus.ACTIVE
        val inactive = TopicStatus.INACTIVE

        assertTrue(topicService.isActive(active))
        assertFalse(topicService.isActive(inactive))
    }

    @Test
    fun `find test`(){
        val topicName = "news"
        every {
            topicRepository.findByTopic(topicName)
        }returns Topic(topicName, TopicStatus.ACTIVE)

        val topic = topicService.find(topicName)
        assertEquals(topicName, topic?.topic)
        assertEquals(TopicStatus.ACTIVE, topic?.status)
    }
}