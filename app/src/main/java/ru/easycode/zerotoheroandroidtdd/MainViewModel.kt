package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Wrapper

class MainViewModel(
    private val repository: Repository.Read,
    private val liveDataWrapper: ListLiveDataWrapper.Mutable,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main
): ViewModel(), ListLiveDataWrapper.Read  {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    override fun liveData() = liveDataWrapper.livedata()
    fun init() {
        viewModelScope.launch(dispatcher) {
            val value = repository.list().map { ItemUi(it.id, it.text) }
            withContext(dispatcherMain) {
                liveDataWrapper.update(value)
            }
        }
    }
    override fun livedata(): LiveData<List<String>> {
        TODO("Not yet implemented")
    }
}