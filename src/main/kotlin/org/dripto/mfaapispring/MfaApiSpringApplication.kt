package org.dripto.mfaapispring

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

fun main(args: Array<String>) {
    runApplication<MfaApiSpringApplication>(*args)
}

@SpringBootApplication
@EnableScheduling
class MfaApiSpringApplication {
    //@Bean
    fun runner(service: ProcessService) = ApplicationRunner {
        service.populate()
    }

}

