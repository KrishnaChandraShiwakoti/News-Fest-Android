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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.c36b.R
import com.example.c36b.view.components.PostCard
import com.example.c36b.view.components.SearchBar
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.c36b.model.Post
import com.example.c36b.repository.PostRepositoryImpl
import com.example.c36b.viewmodel.PostViewModel

@Composable
fun HomeScreen() {
    val postViewModel: PostViewModel = viewModel(factory = object : androidx.lifecycle.ViewModelProvider.Factory {
        override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
            return PostViewModel(PostRepositoryImpl()) as T
        }
    })
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        postViewModel.getAllPosts { result, err ->
            if (result != null) {
                posts = result
                isLoading = false
            } else {
                error = err
                isLoading = false
            }
        }
    }

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

        when {
            isLoading -> {
                Text("Loading posts...")
            }
            error != null -> {
                Text("Error: $error")
            }
            else -> {
                LazyColumn {
                    items(posts) { post ->
                        PostCard(post)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
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
