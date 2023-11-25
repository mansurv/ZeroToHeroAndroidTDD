package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DeleteViewModel(
    private val deleteLiveDataWrapper: ListLiveDataWrapper.Delete,
    private val repository: Repository.Delete,
    private val clear: ClearViewModel,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main
): ViewModel() {
    private val innerLiveData = MutableLiveData<String>(
        val liveData: LiveData<String>
        get() == innerLiveData
    )
}