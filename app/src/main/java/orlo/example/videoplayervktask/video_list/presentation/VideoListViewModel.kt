package orlo.example.videoplayervktask.video_list.presentation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import orlo.example.spendingtracker.spending_overview.presentation.VideoListAction
import orlo.example.spendingtracker.spending_overview.presentation.VideoListState
import orlo.example.videoplayervktask.core.data.remote.VideoRepository
import orlo.example.videoplayervktask.core.data.remote.VideoRepositoryImpl
import java.time.ZonedDateTime

class VideoListViewModel(
    private val videoRepository: VideoRepositoryImpl
): ViewModel() {

    var state by mutableStateOf(VideoListState())
        private set


    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()


    fun onAction(action: VideoListAction) {
        when(action) {
            VideoListAction.LoadingVideoList -> {
                loadVideos()
            }
            is VideoListAction.OnPickVideo -> {
                TODO()
            }
        }
    }

        fun loadVideos() {
            viewModelScope.launch {
                videoRepository.getVideosList()
                    .collect { result ->
                        when (result) {
                            is orlo.example.videoplayervktask.core.data.remote.Result.Error -> {
                                _showErrorToastChannel.send(true)
                            }
                            is orlo.example.videoplayervktask.core.data.remote.Result.Success -> {
                                state = state.copy(videoList = result.data!!)
                            }
                        }
                    }
            }
        }

        init {
            loadVideos()
        }


}