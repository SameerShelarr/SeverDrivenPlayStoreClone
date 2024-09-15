package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sever_driven_playstore_clone.models.BottomNav
import com.example.sever_driven_playstore_clone.models.BottomNavIcon
import com.example.sever_driven_playstore_clone.models.BottomNavItems
import com.example.sever_driven_playstore_clone.models.BottomNavSection
import com.example.sever_driven_playstore_clone.models.Size

@Composable
fun PlayStoreBottomNav(
    bottomNavSection: BottomNavSection,
    onItemSelected: (Int) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar {
        bottomNavSection.list.items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    AsyncImage(
                        model = item.icon.url,
                        contentDescription = item.title,
                        modifier = Modifier.size(
                            height = item.icon.iconSize.height.dp,
                            width = item.icon.iconSize.width.dp,
                        )
                    )
                },
                label = { Text(text = item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onItemSelected.invoke(index)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    // Sample data for preview
    val bottomNavItems = listOf(
        BottomNav(
            icon = BottomNavIcon(
                url = "https://via.placeholder.com/24", // Mock URL for preview
                iconSize = Size(24, 24)
            ),
            title = "Games"
        ),
        BottomNav(
            icon = BottomNavIcon(
                url = "https://via.placeholder.com/24", // Mock URL for preview
                iconSize = Size(24, 24)
            ),
            title = "Apps"
        ),
        BottomNav(
            icon = BottomNavIcon(
                url = "https://via.placeholder.com/24", // Mock URL for preview
                iconSize = Size(24, 24)
            ),
            title = "Search"
        ),
        BottomNav(
            icon = BottomNavIcon(
                url = "https://via.placeholder.com/24", // Mock URL for preview
                iconSize = Size(24, 24)
            ),
            title = "Books"
        )
    )

    val bottomNavSection = BottomNavSection(
        list = BottomNavItems(
            items = bottomNavItems,
            orientation = "horizontal"
        ),
        order = 1
    )

    PlayStoreBottomNav(
        bottomNavSection = bottomNavSection,
        onItemSelected = {
            // Handle item selection
        }
    )
}