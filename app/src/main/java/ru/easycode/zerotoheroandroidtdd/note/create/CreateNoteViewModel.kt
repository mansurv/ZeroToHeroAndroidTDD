package ru.easycode.zerotoheroandroidtdd.note.create

import kotlinx.coroutines.Dispatchers

class CreateNoteViewModel(
    private lateinit var incrementFolder: IncrementFolderLiveDataWrapper,
    private lateinit var repository: CreateNoteRepository,
    private lateinit var addLiveDataWrapper: AddNoteLiveDataWrapper,
    private lateinit var navigation: Navigation.Update,
    private lateinit var clear: Clear,
    val dispatcher = Dispatchers.IO,
    val dispatcherMain = Dispatchers.Main
) {
}