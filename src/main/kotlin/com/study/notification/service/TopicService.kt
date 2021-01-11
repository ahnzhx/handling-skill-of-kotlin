package com.study.notification.service

import com.study.notification.domain.repository.TopicRepository
import com.study.notification.dto.TopicStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.study.notification.util.LoggerDelegate

@Service
@Transactional
class TopicService (
    private val topicRepository: TopicRepository
        ){
    private val log by LoggerDelegate()

    @Transactional(readOnly = true)
    fun find(topicName: String) = topicRepository.findByTopic(topicName)

    fun isActive(topicStatus: TopicStatus) = TopicStatus.ACTIVE == topicStatus
}
