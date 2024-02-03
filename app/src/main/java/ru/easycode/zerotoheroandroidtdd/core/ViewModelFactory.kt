package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory: ProvideViewModel, ClearViewModel {
    class Base(
        private val provideViewModel: ProvideViewModel
    ) : ViewModelFactory {

        private val map = mutableMapOf<Class<out ViewModel>, ViewModel>()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            val value = map[viewModelClass]
            return if (value == null) {
                val viewModel = provideViewModel.viewModel(viewModelClass)
                map[viewModelClass] = viewModel
                viewModel
            } else {
                value as T
            }
        }
        override fun clear(viewModelClass: Class<out ViewModel>) {
            map.remove(viewModelClass)
        }
    }
}