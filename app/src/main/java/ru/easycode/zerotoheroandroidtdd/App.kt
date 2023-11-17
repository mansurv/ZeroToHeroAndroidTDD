package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel

class App: Application() {

    private lateinit var factory: ProvideViewModel
    private val store = HashMap<Class<out ViewModel>, ViewModel?>()
    private val clear = object: ClearViewModel {
        override fun clearViewModel(clasz:Class<out ViewModel>) {
            store[clasz] = null
        }
    }
    override fun onCreate() {
        super.onCreate()
        factory = ProvideViewModel.Base(core, clear)
    }
    override fun<T: ViewModel> viewModel(clasz: Class<T>): T {
        if(store[clasz] == null)
            store[clasz] = factory.viewModel(clasz)
        return store[clasz] as T
    }
}
interface ProvideViewModel{
    fun<T: ViewModel> viewModel(clasz: Class<T>): T
    class Base(core: Core, private val clear: ClearViewModel) {
        private val repository = Repository.Base(core.dao(), Now.Base())
        private val liveDataWrapper = ListLiveDataWrapper.Base()

        override fun<T: ViewModel> viewModel(clasz: Class<T>): T =
            (if(clasz == MainViewModel::class.java)
                MainViewModel(repository, liveDataWrapper)
            else
                AddViewModel(repository, liveDataWrapper,clear)) as T
    }
}
interface ClearViewModel {
    fun clearViewModel(clasz: Class<out ViewModel>): ProvideViewModel {

    }
}