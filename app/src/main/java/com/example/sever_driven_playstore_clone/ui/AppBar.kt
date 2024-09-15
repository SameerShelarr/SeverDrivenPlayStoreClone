package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.models.Actions
import com.example.sever_driven_playstore_clone.models.AppBarSection
import com.example.sever_driven_playstore_clone.models.BellIcon
import com.example.sever_driven_playstore_clone.models.Handler
import com.example.sever_driven_playstore_clone.models.Logo
import com.example.sever_driven_playstore_clone.models.Size
import com.example.sever_driven_playstore_clone.models.Title

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
                    .padding(start = 10.dp, top = 0.dp, end = 18.dp, bottom = 0.dp),
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
