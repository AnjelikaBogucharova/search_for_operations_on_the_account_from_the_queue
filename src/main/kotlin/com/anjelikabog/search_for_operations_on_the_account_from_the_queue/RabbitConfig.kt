package com.anjelikabog.search_for_operations_on_the_account_from_the_queue

import com.anjelikabog.search_for_operations_on_the_account_from_the_queue.repo.OperationsRepository
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Component

@Component
@RabbitListener(queues = ["account"])
class Receiver(
        val operationRepository: OperationsRepository
) {
    @RabbitHandler
    fun receive(
            messageIn: String
    ) {
        println("[x] Received account'$messageIn'")
        operationRepository.findAllByAccountOrderByIdOperations(messageIn).forEach {
            println(it.operation)
        }
    }
}

@Configuration
@EnableScheduling
class TutorialConfiguration
{
    @Bean
    fun account() = Queue("account")


}