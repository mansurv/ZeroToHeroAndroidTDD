package ru.easycode.zerotoheroandroidtdd.core

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room

class App: Application(), ProvideViewModel {
    private lateinit var factory: ViewModelFactory
    private val clear: ClearViewModel = object: ClearViewModel {
        override fun clear(viewModelClass: Class<out ViewModel>) = factory.clear(viewModelClass)
    }
    override fun onCreate() {
        super.onCreate()
        val provideViewModel = ProvideViewModel.Base(clear)
        factory = ViewModelFactory.Base(provideViewModel)
        val database: AppDatabase by lazy {
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "database"
            ).build()
        }
    }
    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T =
        factory.viewModel(viewModelClass)
}