package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {

    interface Update {
        fun update(value: List<String>)
    }
    interface Read {
        fun livedata(): LiveData<List<String>>
    }
    interface Add {
        fun add(value: String)
    }

    interface Mutable: Update, Read
    interface All: Mutable, Add
    class Base: All {

        private val liveData = MutableLiveData<List<String>>()
        override fun update(value: List<String>) {
            liveData.postValue(value)
        }
        override fun livedata(): LiveData<List<String>> {
            return liveData
        }
        override fun add(value: String) {
            val list = liveData.value?.toMutableList()?: ArrayList()
            list.add(value)
            update(list)

    }
}