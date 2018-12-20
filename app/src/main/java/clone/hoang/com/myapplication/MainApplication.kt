package clone.hoang.com.myapplication

import android.app.Application
import clone.hoang.com.myapplication.screen.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}