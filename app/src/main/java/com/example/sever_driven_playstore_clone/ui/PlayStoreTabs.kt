package com.example.sever_driven_playstore_clone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sever_driven_playstore_clone.models.TabsSection
import com.example.sever_driven_playstore_clone.ui.theme.green
import com.example.sever_driven_playstore_clone.ui.theme.grey

@Composable
fun PlayStoreTabs(
    tabsSection: TabsSection
) {
    TabRow(
        selectedTabIndex = 0,
        contentColor = Color(0xFFB7B7B7),
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                // Set the indicator's width dynamically based on the selected tab's width
                Modifier
                    .tabIndicatorOffset(tabPositions[0]) // Dynamic position
                    .width(tabPositions[0].width - 16.dp) // Reduce width for padding
                    .padding(horizontal = 32.dp), // Padding on both sides
                color = green
            )
        }
    ) {
        tabsSection.list.items.forEachIndexed { index, tab ->
            val isSelected = 0 == index
            Tab(
                text = {
                    Text(tab.title, color = if (isSelected) green else grey)
                },
                selected = 0 == index,
                onClick = {}
            )
        }
    }
}