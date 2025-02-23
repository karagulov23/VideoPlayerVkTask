package orlo.example.videoplayervktask.core.data.remote

import orlo.example.videoplayervktask.core.data.remote.model.Hit
import orlo.example.videoplayervktask.core.data.remote.model.VideoDto
import orlo.example.videoplayervktask.core.domain.model.Video

// Mapper function to convert Hit to Video
fun Hit.toVideo(): Video {
    return Video(
        id = this.id,
        type = this.type,
        name = this.user, // Assuming 'user' is the name in this case
        duration = this.duration,
        thumbnail = this.videos.medium.thumbnail // Assuming large thumbnail is the preferred thumbnail
    )
}

// Mapper function to convert VideoDto to List<Video>
fun VideoDto.toVideoList(): List<Video> {
    return this.hits.map { it.toVideo() }
}
