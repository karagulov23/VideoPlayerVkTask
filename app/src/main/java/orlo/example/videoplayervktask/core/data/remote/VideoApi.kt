package orlo.example.videoplayervktask.core.data.remote

import orlo.example.videoplayervktask.core.data.remote.model.VideoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApi {

    @GET("videos")
    suspend fun getVideosByDefault(
        @Query("key") apiKey: String = API_KEY
    ): VideoDto

    companion object {
        const val BASE_URL = "https://pixabay.com/api/"
        const val API_KEY = "49016683-5ffe8247b0bceeca6d7eac260"
    }



}