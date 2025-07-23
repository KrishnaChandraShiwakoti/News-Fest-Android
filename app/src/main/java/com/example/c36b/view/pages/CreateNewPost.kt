package com.example.c36b.view.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreateNewPost() {
    var selectedCategory by remember { mutableStateOf("Breaking News") }
    val categories = listOf("Breaking News", "Politics", "Technology", "Business")

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Text("Create Article", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Category Chips
        Text("Category", style = MaterialTheme.typography.labelMedium)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = {
                        Text(category)
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF2563EB),
                        selectedLabelColor = Color.White,
                        containerColor = Color(0xFFE5E7EB)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
Text(text = "Title", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        // Title Field
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            placeholder = { Text("Enter compelling headline...") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

//         Content Toolbar
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { /* TODO: Implement image picker logic */ }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Image", tint = Color(0xFF2563EB))
            }
            Text(text = "Add image from gallery", modifier = Modifier.alignByBaseline(), color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(8.dp))
Text(text = "Content", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Content Field
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            placeholder = { Text("Write your article content here...") },
            modifier = Modifier.fillMaxWidth().height(120.dp),
            shape = RoundedCornerShape(12.dp),
            maxLines = 6
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Username Field
        Text(text = "Author Name", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        var username by remember { mutableStateOf("") }
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Enter your name...") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Handle Field
        Text(text = "Handle", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        var handle by remember { mutableStateOf("") }
        OutlinedTextField(
            value = handle,
            onValueChange = { handle = it },
            placeholder = { Text("Enter your handle (e.g. johndoe)") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tags Field
        Text(text = "Tags (comma separated)", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        var tags by remember { mutableStateOf("") }
        OutlinedTextField(
            value = tags,
            onValueChange = { tags = it },
            placeholder = { Text("e.g. news, world, trending") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Likes, Comments, Shares (optional, can be set to 0 by default)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            var likes by remember { mutableStateOf(0) }
            var comments by remember { mutableStateOf(0) }
            var shares by remember { mutableStateOf(0) }
            OutlinedTextField(
                value = likes.toString(),
                onValueChange = { likes = it.toIntOrNull() ?: 0 },
                label = { Text("Likes") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = comments.toString(),
                onValueChange = { comments = it.toIntOrNull() ?: 0 },
                label = { Text("Comments") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = shares.toString(),
                onValueChange = { shares = it.toIntOrNull() ?: 0 },
                label = { Text("Shares") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image Picker (already present above as Add Image)
        // You can add logic to display the selected image if needed

        // Submit Button
        Button(
            onClick = {
                // TODO: Handle post creation logic here
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
        ) {
            Text("Publish Article", color = Color.White)
        }
    }
}
