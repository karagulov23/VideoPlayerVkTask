package orlo.example.spendingtracker.spending_overview.presentation

import orlo.example.videoplayervktask.core.domain.model.Video

data class VideoListState(
    val videoList: List<Video> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
