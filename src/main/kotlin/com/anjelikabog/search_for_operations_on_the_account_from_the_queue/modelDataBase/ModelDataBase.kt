package com.anjelikabog.search_for_operations_on_the_account_from_the_queue.modelDataBase

import javax.persistence.*


@Entity
@Table(name = "operations")
data class OperationsDB(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false, insertable = false)
        val idOperations: Long? = null,

        @Column(nullable = false)
        val account: String? = null,

        @Column(nullable = false)
        val operation: String? = null
)