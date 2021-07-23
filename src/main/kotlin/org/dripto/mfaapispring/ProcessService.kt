package org.dripto.mfaapispring

import org.springframework.data.domain.Pageable
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import kotlin.random.Random

@Service
class ProcessService(private val repo: ProcessRepo){
    fun populate() {
        repo.saveAll(List(100){
            ProcessEntity(id = it + 1L)
        })
        println(repo.findAll())
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    @Transactional
    fun process() {
        val openProcesses = repo.findAllByStatusOrderByProcessedTimeAsc(ProcessEntity.Status.open, Pageable.ofSize(10))
        openProcesses.forEach {
            Thread.sleep(Random.nextLong(1000))
            if(Random.nextBoolean()) {
                repo.save(it.copy(status = ProcessEntity.Status.closed, processedTime = Instant.now()))
                println("updated: ${it.id}")
            } else {
                repo.save(it.copy(processedTime = Instant.now()))
                println("not updated: ${it.id}")
            }
        }
    }
}