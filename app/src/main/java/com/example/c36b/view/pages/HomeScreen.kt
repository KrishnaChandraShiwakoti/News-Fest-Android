package com.example.c36b.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.c36b.R
import com.example.c36b.view.components.Post
import com.example.c36b.view.components.PostCard
import com.example.c36b.view.components.SearchBar
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "BlogSpace",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Discover amazing stories",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(12.dp))

        FilterChips()

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(dummyPosts) { post ->
                PostCard(post)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun FilterChips() {
    val categories = listOf("All", "Technology", "Lifestyle", "Travel", "Food")
    var selected by remember { mutableStateOf("All") }

    LazyRow {
        items(categories.size) { index ->
            val category = categories[index]
            FilterChip(
                selected = selected == category,
                onClick = { selected = category },
                label = { Text(category) },
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

val dummyPosts = listOf(
    Post(
        username = "Sarah Chen",
        handle = "sarahc",
        time = "2h",
        content = "Just finished reading an amazing book about mindfulness and productivity...",
        tags = listOf("mindfulness", "productivity", "reading"),
        likes = 124,
        comments = 18,
        shares = 1,
        imageRes = R.drawable.ic_launcher_background // Use an actual drawable
    ),
            Post(
            username = "Sarah Chen",
    handle = "sarahc",
    time = "2h",
    content = "Just finished reading an amazing book about mindfulness and productivity...",
    tags = listOf("mindfulness", "productivity", "reading"),
    likes = 124,
    comments = 18,
    shares = 1,
    imageRes = R.drawable.ic_launcher_background // Use an actual drawable
),
    Post(
        username = "Sarah Chen",
handle = "sarahc",
time = "2h",
content = "Just finished reading an amazing book about mindfulness and productivity...",
tags = listOf("mindfulness", "productivity", "reading"),
likes = 124,
comments = 18,
shares = 1,
imageRes = R.drawable.ic_launcher_background // Use an actual drawable
)
)
