package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.models.Actions
import com.example.sever_driven_playstore_clone.models.App
import com.example.sever_driven_playstore_clone.models.AppBarSection
import com.example.sever_driven_playstore_clone.models.AppsListSection
import com.example.sever_driven_playstore_clone.models.BellIcon
import com.example.sever_driven_playstore_clone.models.Handler
import com.example.sever_driven_playstore_clone.models.Logo
import com.example.sever_driven_playstore_clone.models.Size
import com.example.sever_driven_playstore_clone.models.Title

@Composable
fun AppsListScreen(
    appsListSection: AppsListSection,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appsListSection.list.items) { app ->
            AppItem(app)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    appBarSection: AppBarSection,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 0.dp, end = 12.dp, bottom = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Logo
                AsyncImage(
                    model = appBarSection.logo.url,
                    contentDescription = appBarSection.logo.title.text,
                    modifier = Modifier
                        .width(appBarSection.logo.size.width.dp)
                        .height(appBarSection.logo.size.height.dp),
                    contentScale = ContentScale.Crop
                )

                // Bell Icon
                AsyncImage(
                    model = appBarSection.bellIcon.url,
                    contentDescription = "bell icon",
                    modifier = Modifier
                        .width(appBarSection.bellIcon.size.width.dp)
                        .height(appBarSection.bellIcon.size.height.dp),
                    contentScale = ContentScale.Crop
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewAppBar() {
    val sampleAppBarSection = AppBarSection(
        bellIcon = BellIcon(
            count = 5,
            handler = Handler(
                actions = Actions(navigate = ""),
                type = "click"
            ),
            scaleType = "fit",
            shouldShowCount = true,
            size = Size(24, 24),
            url = "https://example.com/bell_icon.png"
        ),
        logo = Logo(
            scaleType = "fit",
            size = Size(100, 40),
            title = Title(
                fontWeight = "bold",
                size = 14,
                text = "Play Store"
            ),
            url = "https://example.com/logo.png"
        ),
        order = 1
    )

    AppBar(appBarSection = sampleAppBarSection)
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