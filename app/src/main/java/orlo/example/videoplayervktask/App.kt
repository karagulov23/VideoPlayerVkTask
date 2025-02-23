package orlo.example.videoplayervktask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import orlo.example.videoplayervktask.core.di.coreModule
import orlo.example.videoplayervktask.video_list.di.videoListModule
import orlo.example.videoplayervktask.video_player.di.videoPlayerModule

class App: Application()  {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                videoPlayerModule,
                videoListModule
            )
        }

    }
}