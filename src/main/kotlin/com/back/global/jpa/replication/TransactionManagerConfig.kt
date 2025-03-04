package com.back.global.jpa.replication

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
class TransactionManagerConfig {
    @Primary
    @Bean
    fun transactionManager(dataSource: DataSource): DataSourceTransactionManager {
        val transactionManager = DataSourceTransactionManager()
        transactionManager.dataSource = dataSource
        return transactionManager
    }

    fun readTransactionManager(dataSource: DataSource): DataSourceTransactionManager {
        val transactionManager = DataSourceTransactionManager()
        transactionManager.dataSource = dataSource
        transactionManager.isEnforceReadOnly = false
        return transactionManager
    }
}