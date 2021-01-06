package service

import domain.model.Topic
import domain.repository.TopicRepository
import dto.TopicStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import util.LoggerDelegate

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
