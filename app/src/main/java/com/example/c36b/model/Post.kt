package com.example.c36b.model

import android.net.Uri

data class Post(
    val username: String,
    val time: String,
    val content: String,
    val tags: List<String>,
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val imageUrl: String? = null,
    val imageUri: Uri? = null
)
