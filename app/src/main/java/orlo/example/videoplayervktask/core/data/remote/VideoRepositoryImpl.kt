package orlo.example.videoplayervktask.core.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import orlo.example.videoplayervktask.core.domain.model.Video
import retrofit2.HttpException
import java.io.IOException

class VideoRepositoryImpl(
    private val api: VideoApi
): VideoRepository {

    override suspend fun getVideosList(): Flow<Result<List<Video>>> {
        return flow {
            val videosFromApi = try {
                api.getVideosByDefault()

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }  catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }
            emit(Result.Success(videosFromApi.toVideoList()))
        }

    }

}