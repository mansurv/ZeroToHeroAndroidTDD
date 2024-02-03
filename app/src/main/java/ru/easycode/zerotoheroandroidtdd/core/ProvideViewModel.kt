package ru.easycode.zerotoheroandroidtdd.core

import MainViewModel
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.folder.create.FolderCreateViewModel
import ru.easycode.zerotoheroandroidtdd.folder.list.FoldersListViewModel
import ru.easycode.zerotoheroandroidtdd.folder.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T
    class Base(
        private val clearViewModel: ClearViewModel
    ): ProvideViewModel {

        private val navigation = Navigation.Base()
        private val sharedLiveData: ListLiveDataWrapper.All = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(navigation)
                FoldersListViewModel::class.java -> FoldersListViewModel(sharedLiveData, navigation)
                FolderCreateViewModel::class.java -> FolderCreateViewModel(sharedLiveData, navigation, clearViewModel)
                else -> throw IllegalStateException("unknown viewModelClass $viewModelClass")
            } as T
        }
    }
}