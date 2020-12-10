package domain.model

import javax.persistence.*

@Entity
class Notification(
    @Column(name="message")
    var message: String,

    @JoinColumn(name="topicId")
    @ManyToOne(fetch=FetchType.LAZY)
    var topic: Topic

) : AuditingEntity() {
    override fun toString(): String {
        return "Notification(" +
                "id=$id, " +
                "message='$message', " +
                "topic=$topic)"
    }
}