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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.models.App
import com.example.sever_driven_playstore_clone.models.AppsListSection
import com.example.sever_driven_playstore_clone.models.Size
import com.example.sever_driven_playstore_clone.ui.theme.grey

@Composable
fun AppsListScreen(
    appsListSection: AppsListSection,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appsListSection.list.items) { app ->
            AppItem(
                app = app,
                iconSize = appsListSection.list.iconSize,
                titleFontSize = appsListSection.list.titleFontSize,
                subtitleFontSize = appsListSection.list.subtitleFontSize,
            )
        }
    }
}

@Composable
fun AppItem(
    app: App,
    iconSize: Size,
    titleFontSize: Int,
    subtitleFontSize: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        // App Icon
        AsyncImage(
            model = app.icon,
            contentDescription = app.title,
            modifier = Modifier
                .size(
                    height = iconSize.height.dp,
                    width = iconSize.width.dp,
                )
                .padding(4.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart
        )

        Spacer(modifier = Modifier.width(8.dp))

        // App Details (Title, Subtitle, Rating)
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            // Title
            Text(
                text = app.title,
                fontSize = titleFontSize.sp,
                fontWeight = FontWeight.Bold,
                color = grey,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Subtitle
            Text(
                text = app.subtitle,
                fontSize = subtitleFontSize.sp,
                color = grey,
                lineHeight = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = app.rating.toString(),
                    fontSize = subtitleFontSize.sp,
                    color = grey,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Filled.Star),
                    contentDescription = "star",
                    tint = grey,
                    modifier = Modifier
                        .size(10.dp)
                        .align(Alignment.CenterVertically),
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
        rating = 4.5,
        subtitle = "A great app for your needs",
        title = "Cool App",
    )

    AppItem(
        app = sampleApp,
        iconSize = Size(64, 64),
        titleFontSize = 16,
        subtitleFontSize = 12,
    )
}