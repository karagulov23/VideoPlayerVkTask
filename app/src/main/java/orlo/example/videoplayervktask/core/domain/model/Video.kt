package orlo.example.videoplayervktask.core.domain.model

data class Video(
    val id: Int,
    val type: String,
    val name: String,
    val duration: Int,
    val thumbnail: String
)