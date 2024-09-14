package com.example.sever_driven_playstore_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sever_driven_playstore_clone.models.PlayStoreHome
import com.example.sever_driven_playstore_clone.ui.AppBar
import com.example.sever_driven_playstore_clone.ui.AppsListScreen
import com.example.sever_driven_playstore_clone.ui.PlayStoreTabs
import com.example.sever_driven_playstore_clone.ui.theme.SeverDrivenPlayStoreCloneTheme
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val state by viewModel.playStoreHomeFlow.collectAsStateWithLifecycle()

            SeverDrivenPlayStoreCloneTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        state?.appBarSection?.let {
                            AppBar(it)
                        }
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        state?.tabsSection?.let {
                            PlayStoreTabs(
                                tabsSection = it
                            )
                        }
                        state?.appsListSection?.let {
                            AppsListScreen(
                                appsListSection = it,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppName(state: StateFlow<PlayStoreHome?>, modifier: Modifier = Modifier) {

    val t by state.collectAsState()

    Text(
        text = "App Name: ${t?.appsListSection?.list?.items?.first()?.title}!",
        modifier = modifier
    )
}