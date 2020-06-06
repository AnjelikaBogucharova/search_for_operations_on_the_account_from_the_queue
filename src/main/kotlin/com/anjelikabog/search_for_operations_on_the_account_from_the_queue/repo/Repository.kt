package com.anjelikabog.search_for_operations_on_the_account_from_the_queue.repo

import com.anjelikabog.search_for_operations_on_the_account_from_the_queue.modelDataBase.OperationsDB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperationsRepository : JpaRepository<OperationsDB, Long> {
    fun findAllByAccountOrderByIdOperations(account: String): List<OperationsDB>
}