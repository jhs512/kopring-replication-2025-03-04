package com.back.domain.post.post.controller

import com.back.domain.post.post.entity.Post
import com.back.domain.post.post.service.PostService
import com.back.global.jpa.ReadTransactional
import org.springframework.transaction.annotation.Transactional

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/posts")
class ApiV1PostController(
    private val postService: PostService
) {
    @GetMapping
    @ReadTransactional
    fun getItems(): List<Post> = postService.findAll()

    @GetMapping("/write")
    @Transactional
    fun write(
        title: String,
        content: String
    ): Post {
        return postService.write(title, content)
    }
}