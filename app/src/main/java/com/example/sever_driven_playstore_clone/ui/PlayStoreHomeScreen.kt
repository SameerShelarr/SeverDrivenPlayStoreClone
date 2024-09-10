package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.MainViewModel
import com.example.sever_driven_playstore_clone.models.App
import com.example.sever_driven_playstore_clone.models.Size

@Composable
fun PlayStoreHomeScreen(
    viewModeL: MainViewModel,
    modifier: Modifier,
) {
    val state by viewModeL.playStoreHomeFlow.collectAsStateWithLifecycle()

    val apps = state?.appsListSection?.list?.items

    apps?.let {
        LazyColumn(
            modifier = modifier
        ) {
            items(it) { app ->
                AppItem(app)
            }
        }
    }
}

@Composable
fun AppItem(app: App) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // App Icon
            AsyncImage(
                model = app.icon,
                contentDescription = app.title,
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            // App Details (Title, Subtitle, Rating)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                // Title
                Text(
                    text = app.title,
                    fontSize = app.titleFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Subtitle
                Text(
                    text = app.subtitle,
                    fontSize = app.subtitleFontSize.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Rating (e.g., "3.8 stars")
                Text(
                    text = String.format("%.1f stars", app.rating),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppItem() {
    val sampleApp = App(
        icon = "https://example.com/icon.png", // Replace with an actual icon URL
        iconSize = Size(64, 64),
        rating = 4.5,
        subtitle = "A great app for your needs",
        subtitleFontSize = 12,
        title = "Cool App",
        titleFontSize = 16
    )

    AppItem(app = sampleApp)
}