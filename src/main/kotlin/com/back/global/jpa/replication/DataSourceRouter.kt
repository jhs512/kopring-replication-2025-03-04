package com.back.global.jpa.replication

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager
import java.util.*


class DataSourceRouter : AbstractRoutingDataSource() {
    private val random = Random()

    override fun determineCurrentLookupKey(): Any {
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly())
            return random.nextInt(2) + 1

        return 0
    }
}