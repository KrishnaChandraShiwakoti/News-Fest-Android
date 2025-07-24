package com.example.c36b.repository

interface BookmarkRepository {
    fun addToBookmarks(postId: String, userId: String, onSuccess: () -> Unit, onError: (String) -> Unit)
    fun removeFromBookmarks(postId: String, userId: String, onSuccess: () -> Unit, onError: (String) -> Unit)
}