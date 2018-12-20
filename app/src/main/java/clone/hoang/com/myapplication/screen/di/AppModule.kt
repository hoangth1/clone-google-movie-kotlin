package clone.hoang.com.myapplication.screen.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module(override = true) {
    single { androidApplication().resources }

}
val modules = listOf(
    appModule,
    viewModeModule
)