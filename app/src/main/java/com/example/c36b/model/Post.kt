package com.example.c36b.model

data class Post(
    val username: String,
    val handle: String,
    val time: String,
    val content: String,
    val tags: List<String>,
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val imageRes: Int
)
