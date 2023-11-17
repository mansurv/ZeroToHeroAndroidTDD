package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListScreen

class MainViewModel(
    private val navigation: Navigation.Mutable
) : Navigation.Read {
    override fun liveData() = navigation.liveData()
    fun init(firstRun: Boolean) {
        if(firstRun)
            navigation.update(ListScreen)
    }

}