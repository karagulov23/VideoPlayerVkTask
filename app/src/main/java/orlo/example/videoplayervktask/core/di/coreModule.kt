package orlo.example.videoplayervktask.core.di

import org.koin.dsl.module
import orlo.example.videoplayervktask.core.data.remote.VideoApi
import orlo.example.videoplayervktask.core.data.remote.VideoApi.Companion.BASE_URL
import orlo.example.videoplayervktask.core.data.remote.VideoRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideoApi::class.java)
    }

    single {
        VideoRepositoryImpl(get())
    }

}