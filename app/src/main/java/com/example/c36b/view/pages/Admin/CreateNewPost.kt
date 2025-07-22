package com.example.c36b.view.pages.Admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.c36b.R

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
            placeholder = { Text("Start writing your article...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(12.dp),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Action Buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton (
                onClick = { /* Save Draft logic */ },
                modifier = Modifier.weight(1f)
            ) {
                Image(painter = painterResource(R.drawable.outline_article_24), contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Save Draft")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { /* Publish logic */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Create, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Publish")
            }
        }
    }
}
