package ru.easycode.zerotoheroandroidtdd.folder.list

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.folder.create.FolderCreateScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class FoldersListViewModel(
    private val liveDataWrapper: FoldersListLiveDataWrapper.Mutable,
    private val navigation: Navigation.Update
): ViewModel(), FoldersListLiveDataWrapper.Read {
    override fun liveData() = liveDataWrapper.liveData()

    fun create() {
        navigation.update(FolderCreateScreen)
    }
    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val list = bundleWrapper.restore()
        liveDataWrapper.update(list)
    }
}