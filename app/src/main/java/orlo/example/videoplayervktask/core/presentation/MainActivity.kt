package orlo.example.videoplayervktask.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem
import orlo.example.spendingtracker.core.presentation.util.Screen
import orlo.example.videoplayervktask.core.presentation.ui.theme.VideoPlayerVkTaskTheme
import orlo.example.videoplayervktask.video_list.presentation.VideoListScreenCore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideoPlayerVkTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.VideoList
    ) {

        composable<Screen.VideoList> {
            VideoListScreenCore()
        }

        composable<Screen.VidePlayer> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Video Player")
                VideoPlayer(
                    mediaItems = listOf(
                        VideoPlayerMediaItem.NetworkMediaItem(
                            "https://cdn.pixabay.com/video/2019/04/06/22634-328940142_large.mp4"
                        )
                    )
                )
            }
        }

    }
}
