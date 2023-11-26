package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T
    class Base: ProvideViewModel {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainVievModel::class.java -> MainViewModel(Navigation.Base())
                else -> throw IllegalStateException("ünknown viewModelClass $vieModelClass")
            } as T
        }

    }
}