package com.back.global.initData

import com.back.domain.post.post.service.PostService
import com.back.global.jpa.ReadTransactional

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.transaction.annotation.Transactional
import java.lang.Thread.sleep


@Configuration
class BaseInitData(
    private val postService: PostService
) {
    @Autowired
    @Lazy
    lateinit var self: BaseInitData

    @Bean
    fun baseInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            sleep(10000)

            self.work1()
            self.work2()
            self.work3()
            self.work4()
        }
    }

    @Transactional
    fun work1() {
        postService.write("title 1", "content 1")
        postService.write("title 2", "content 2")
    }

    @ReadTransactional
    fun work2() {
        postService.findAll()
            .forEach { println(it.id) }
    }

    @ReadTransactional
    fun work3() {
        postService.findAll()
            .forEach { println(it.id) }
    }

    @ReadTransactional
    fun work4() {
        postService.findAll()
            .forEach { println(it.id) }
    }
}