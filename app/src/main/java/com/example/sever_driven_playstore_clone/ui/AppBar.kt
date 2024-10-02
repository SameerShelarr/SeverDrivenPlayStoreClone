package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.models.AppBarSection
import com.example.sever_driven_playstore_clone.models.BellIcon
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
                Row {
                    AsyncImage(
                        model = appBarSection.logo.url,
                        contentDescription = appBarSection.logo.title.text,
                        modifier = Modifier
                            .width(appBarSection.logo.size.width.dp)
                            .height(appBarSection.logo.size.height.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    if (appBarSection.logo.title.shouldShowTitle) {
                        appBarSection.logo.title.apply {
                            Text(
                                text = text,
                                fontSize = size.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = when (fontWeight) {
                                    "bold" -> FontWeight.Bold
                                    "medium" -> FontWeight.Medium
                                    "thin" -> FontWeight.Thin
                                    else -> FontWeight.Normal
                                },
                                modifier = Modifier.align(
                                    alignment = Alignment.CenterVertically
                                )
                            )
                        }
                    }
                }

                // Bell Icon
                Box(
                    modifier = Modifier
                        .width(appBarSection.bellIcon.size.width.dp)
                        .height(appBarSection.bellIcon.size.height.dp)
                ) {
                    // Bell Icon
                    AsyncImage(
                        model = appBarSection.bellIcon.url,
                        contentDescription = "bell icon",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    // Red Dot (Notification Badge)
                    Box(
                        modifier = Modifier
                            .width(appBarSection.bellIcon.size.width.dp)
                            .height(appBarSection.bellIcon.size.height.dp)
                    ) {
                        // Bell Icon
                        AsyncImage(
                            model = appBarSection.bellIcon.url,
                            contentDescription = "bell icon",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Red Dot (Notification Badge)
                        if (appBarSection.bellIcon.shouldShowRedDot) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp) // Size of the red dot
                                    .align(Alignment.TopEnd) // Align to the top-end (top-right)
                                    .offset(
                                        x = (-4).dp,
                                        y = 4.dp
                                    ) // Slight offset to adjust the position
                                    .background(Color.Red, shape = CircleShape)
                            )
                        }
                    }
                }
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
            shouldShowRedDot = true,
            size = Size(24, 24),
            url = "https://example.com/bell_icon.png"
        ),
        logo = Logo(
            size = Size(100, 40),
            title = Title(
                fontWeight = "bold",
                size = 14,
                text = "Play Store",
                shouldShowTitle = true
            ),
            url = "https://example.com/logo.png"
        ),
    )

    AppBar(appBarSection = sampleAppBarSection)
}
