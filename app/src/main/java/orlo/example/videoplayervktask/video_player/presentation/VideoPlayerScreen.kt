package orlo.example.videoplayervktask.video_player.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import orlo.example.videoplayervktask.video_player.util.Player


@Composable
private fun VideoPlayerScreen(
    videoUrl: String
) {
    Player(videoUrl = videoUrl)
}
