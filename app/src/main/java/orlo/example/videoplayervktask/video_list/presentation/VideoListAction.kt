package orlo.example.spendingtracker.spending_overview.presentation


sealed interface VideoListAction {

    data object LoadingVideoList: VideoListAction

    data class OnPickVideo(val videoUrl: String): VideoListAction

}

