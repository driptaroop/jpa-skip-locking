package org.dripto.mfaapispring

import org.hibernate.Hibernate
import org.hibernate.cfg.AvailableSettings
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.QueryHints
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.LockModeType
import javax.persistence.QueryHint
import javax.persistence.Table
import kotlin.random.Random

@Entity
@Table(name = "process")
data class ProcessEntity(
    @Id
    val id: Long = Random.nextLong(),
    @Enumerated(EnumType.STRING)
    val status: Status = Status.open,
    val value: UUID = UUID.randomUUID(),
    @Column(name = "process_time")
    val processedTime: Instant = Instant.now()
){
    enum class Status {
        open, closed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProcessEntity

        return id == other.id
    }

    override fun hashCode(): Int = 1061830756

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , status = $status , value = $value , processedTime = $processedTime )"
    }
}

interface ProcessRepo: JpaRepository<ProcessEntity, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(QueryHint(name = AvailableSettings.JPA_LOCK_TIMEOUT, value = "-2"))
    fun findAllByStatusOrderByProcessedTimeAsc(status: ProcessEntity.Status, pageable: Pageable): List<ProcessEntity>
}