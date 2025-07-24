package com.example.c36b.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.c36b.model.Post
import com.example.c36b.view.components.PostCard

@Composable
fun BookmarkScreen(bookmarkedPosts: List<Post> = emptyList()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    )
    {
        Text("Bookmarked Posts", color = Color.White)
        if (bookmarkedPosts.isEmpty()) {
            Text("No bookmarks yet.", color = Color.Gray)
        } else {
            LazyColumn {
                items(bookmarkedPosts) { post ->
                    PostCard(
                        post = post,
                        onLike = { /* TODO: Implement like functionality for bookmarks */ },
                        onComment = { /* TODO: Implement comment modal for bookmarks */ }
                    )
                }
            }
        }
    }
}