package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class AddViewModel(

    private val repository: Repository.Add,
    private val liveDataWrapper: ListLiveDataWrapper.Add,
    private val clear: ClearViewModel,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

): ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    fun add(value:String) {
        viewModelScope.launch(dispatcher) {
            repository.add(value)
            liveDataWrapper.add(value)
            comeback()
        }
    }

    fun comeback() {
        clear.clearViewModel(addViewModel::class.java)
    }
}