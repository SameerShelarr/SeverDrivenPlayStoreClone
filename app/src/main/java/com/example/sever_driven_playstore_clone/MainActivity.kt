package com.example.sever_driven_playstore_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.sever_driven_playstore_clone.models.PlayStoreHome
import com.example.sever_driven_playstore_clone.ui.theme.SeverDrivenPlayStoreCloneTheme
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeverDrivenPlayStoreCloneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    AppName(
                        state = viewModel.playStoreHomeFlow,
                        modifier = Modifier.padding(innerPadding)
                    )
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