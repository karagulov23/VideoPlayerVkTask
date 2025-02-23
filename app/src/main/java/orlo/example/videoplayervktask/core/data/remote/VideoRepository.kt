package orlo.example.videoplayervktask.core.data.remote

import kotlinx.coroutines.flow.Flow
import orlo.example.videoplayervktask.core.domain.model.Video

interface VideoRepository {

    suspend fun getVideosList(): Flow<Result<List<Video>>>

}