package orlo.example.spendingtracker.core.presentation.util

sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object VideoList: Screen

    @kotlinx.serialization.Serializable
    data class VidePlayer(val videoUrl: String): Screen


}