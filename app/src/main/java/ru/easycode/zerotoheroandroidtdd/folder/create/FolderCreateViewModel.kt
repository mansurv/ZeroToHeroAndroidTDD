package ru.easycode.zerotoheroandroidtdd.folder.create

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.folder.list.FoldersListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen

class FolderCreateViewModel (
    private val addLiveDataWrapper: FoldersListLiveDataWrapper.Add,
    private val navigation: Navigation.Update,
    val clearViewModel: ClearViewModel
): ViewModel() {

    fun add(text: CharSequence) {
        addLiveDataWrapper.add(text)
        comeback()
    }
    fun comeback() {
        navigation.update(Screen.Pop)
        clearViewModel.clear(FolderCreateViewModel::class.java)
    }
}