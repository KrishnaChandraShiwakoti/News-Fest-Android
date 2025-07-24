package com.example.c36b.repository

class BookmarkRepositoryImpl: BookmarkRepository {
    override fun addToBookmarks(
        postId: String,
        userId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun removeFromBookmarks(
        postId: String,
        userId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }
}