package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sever_driven_playstore_clone.models.Size
import com.example.sever_driven_playstore_clone.models.Tab
import com.example.sever_driven_playstore_clone.models.TabsList
import com.example.sever_driven_playstore_clone.models.TabsSection
import com.example.sever_driven_playstore_clone.ui.theme.green
import com.example.sever_driven_playstore_clone.ui.theme.grey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayStoreTabs(
    tabsSection: TabsSection,
    onTabSelected: (Int) -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    PrimaryTabRow(
        selectedTabIndex = selectedTab,
        contentColor = Color(0xFFB7B7B7),
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(
                        selectedTab,
                        matchContentSize = true,
                    )
                    .absoluteOffset(x = 0.dp, y = 5.dp),
                width = Dp.Unspecified,
                height = 8.dp,
                color = green
            )
        }
    ) {
        tabsSection.list.items.forEachIndexed { index, tab ->
            val isSelected = selectedTab == index
            Tab(
                text = {
                    Text(tab.title, color = if (isSelected) green else grey)
                },
                selected = selectedTab == index,
                onClick = {
                    selectedTab = index
                    onTabSelected.invoke(index)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayStoreTabsPreview() {
    // Sample data for the preview
    val tabs = listOf(
        Tab(
            fontSize = 14,
            iconSize = Size(24, 24),
            showRedDot = false,
            title = "Home"
        ),
        Tab(
            fontSize = 14,
            iconSize = Size(24, 24),
            showRedDot = true,
            title = "Games"
        ),
        Tab(
            fontSize = 14,
            iconSize = Size(24, 24),
            showRedDot = false,
            title = "Movies"
        )
    )

    val tabsSection = TabsSection(
        list = TabsList(
            items = tabs,
            orientation = "horizontal"
        ),
        order = 1
    )

    // Render the PlayStoreTabs composable with the sample data
    PlayStoreTabs(tabsSection = tabsSection) { }
}
