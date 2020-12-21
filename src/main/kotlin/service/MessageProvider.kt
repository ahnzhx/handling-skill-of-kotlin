package service

import domain.repository.NotificationRepository
import org.springframework.stereotype.Service
import util.LogUtils
import javax.transaction.Transactional

@Service
@Transactional
class MessageProvider (
    val notificationRepository: NotificationRepository
    ){
    private val log by LogUtils


}