package domain.model

import dto.TopicStatus
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Topic(
    @Column(name="topic")
    var topic: String,

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    var status: TopicStatus

): AuditingEntity() {
    override fun toString(): String {
        return "Topic(" +
                "id=$id, " +
                "topic='$topic', " +
                "status=$status)"
    }
}