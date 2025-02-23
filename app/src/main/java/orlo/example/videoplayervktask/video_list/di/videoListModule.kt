package orlo.example.videoplayervktask.video_list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import orlo.example.videoplayervktask.core.data.remote.VideoRepository
import orlo.example.videoplayervktask.video_list.presentation.VideoListViewModel

val videoListModule = module {

    viewModel {
        VideoListViewModel(get())
    }


}