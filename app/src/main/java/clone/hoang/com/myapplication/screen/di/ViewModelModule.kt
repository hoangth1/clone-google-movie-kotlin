package clone.hoang.com.myapplication.screen.di

import clone.hoang.com.myapplication.screen.ui.fragment.main.MainViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModeModule = module(override = true) {
    viewModel<MainViewModel>()
}
