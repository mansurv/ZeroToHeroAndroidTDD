package ru.easycode.zerotoheroandroidtdd.folder.create

import kotlinx.coroutines.Dispatchers

class CreateFolderViewModel(
    private lateinit var liveDataWrapper: AddLiveDataWrapper,
    private lateinit var navigation: Navigation.Update,
    private lateinit var repository: CreateRepository,
    private lateinit var clear: Clear,
    val dispatcher = Dispatchers.IO,
    val dispatcherMain = Dispatchers.Main
) {
}