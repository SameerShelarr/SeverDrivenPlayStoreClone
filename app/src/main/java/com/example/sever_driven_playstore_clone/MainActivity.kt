package com.example.sever_driven_playstore_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sever_driven_playstore_clone.ui.AppBar
import com.example.sever_driven_playstore_clone.ui.AppsListScreen
import com.example.sever_driven_playstore_clone.ui.PlayStoreBottomNav
import com.example.sever_driven_playstore_clone.ui.PlayStoreTabs
import com.example.sever_driven_playstore_clone.ui.theme.SeverDrivenPlayStoreCloneTheme
import com.example.sever_driven_playstore_clone.ui.theme.green
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val state by viewModel.playStoreHomeFlow.collectAsStateWithLifecycle()

            SeverDrivenPlayStoreCloneTheme {
                state?.let {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            AppBar(it.appBarSection)
                        },
                        bottomBar = {
                            PlayStoreBottomNav(bottomNavSection = it.bottomNavSection) { }
                        }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            PlayStoreTabs(
                                tabsSection = it.tabsSection
                            ) { }
                            AppsListScreen(
                                appsListSection = it.appsListSection,
                            )
                        }
                    }
                } ?: run {
                    var isLoadingTimedOut by remember { mutableStateOf(false) }
                    val timeOutDuration = 10_000L

                    // LaunchedEffect to delay for 30 seconds, then switch to error state
                    LaunchedEffect(isLoadingTimedOut) {
                        if (isLoadingTimedOut.not()) {
                            delay(timeMillis = timeOutDuration)
                            isLoadingTimedOut = true
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isLoadingTimedOut) {
                            Text(
                                text = "Oops, something went wrong!",
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.error,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            LinearProgressIndicator(
                                color = green
                            )
                        }
                    }
                }
            }
        }
    }
}
