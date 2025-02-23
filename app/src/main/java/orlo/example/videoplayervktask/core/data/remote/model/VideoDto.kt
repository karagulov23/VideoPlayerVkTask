package orlo.example.videoplayervktask.core.data.remote.model

data class VideoDto(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)

data class Videos(
    val large: Large,
    val medium: Medium,
    val small: Small,
    val tiny: Tiny
)

data class Tiny(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)


data class Small(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Medium(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Large(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Hit(
    val comments: Int,
    val downloads: Int,
    val duration: Int,
    val id: Int,
    val likes: Int,
    val pageURL: String,
    val tags: String,
    val type: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val videos: Videos,
    val views: Int
)
