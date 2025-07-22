package com.example.c36b.view.pages.Admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.c36b.R
import com.example.c36b.model.Article
import com.example.c36b.view.components.OverviewCard
import com.example.c36b.view.components.OverviewIcon
import com.example.c36b.view.components.RecentArticles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xE9FF5C5C),
                titleContentColor = Color.Black,
            ),
            title = {
                Text("Small Top App Bar")
            }
        )
    }) {innerPadding ->
        Column (modifier = Modifier.fillMaxSize()) {
            Column {
                Text("Today's OverView",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    OverviewCard(
                        icon = OverviewIcon.Vector(Icons.Default.Home),
                        value = "125.4K",
                        label = "Total Views",
                        change = "+12%",
                        changeColor = Color(0xFF3FAD50)
                    )

                    OverviewCard(
                        icon = OverviewIcon.Vector(Icons.Default.Favorite),
                        value = "8.2K",
                        label = "Likes",
                        change = "-8%",
                        changeColor = Color(0xFFE74C3C)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Row 2
                Row(modifier = Modifier.fillMaxWidth()) {
                    OverviewCard(
                        icon = OverviewIcon.PainterIcon(painterResource(R.drawable.outline_comment_24)),
                        value = "1.5K",
                        label = "Comments",
                        change = "+15%",
                        changeColor = Color(0xFF3FAD50)
                    )

                    OverviewCard(
                        icon = OverviewIcon.PainterIcon(painterResource(R.drawable.outline_article_24)),
                        value = "47",
                        label = "Articles",
                        change = "+3%",
                        changeColor = Color(0xFFFFA500)
                    )
                }
            }
             PreviewRecentArticles()
        }
    }

}

@Composable
fun PreviewRecentArticles() {
    val sampleArticles = listOf(
        Article("Breaking: New Technology Breakthrough", "Published", "2 hours ago", "12.3K"),
        Article("Breaking: New Technology Breakthrough", "Published", "2 hours ago", "12.3K"),
        Article("Breaking: New Technology Breakthrough", "Published", "2 hours ago", "12.3K"),
        Article("Breaking: New Technology Breakthrough", "Published", "2 hours ago", "12.3K"),
        Article("Climate Change Impact on Agriculture", "Draft", "1 day ago", "0"),
        Article("Economic Outlook for 2024", "Published", "3 days ago", "8.7K")
    )
    RecentArticles(articles = sampleArticles)
}
