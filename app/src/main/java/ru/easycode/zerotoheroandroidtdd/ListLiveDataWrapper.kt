package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {

    interface Update {
        fun update(list: List<ItemUi>)
    }
    interface Read {
        fun liveData(): LiveData<List<ItemUi>>
    }
    interface Add {
        fun add(value: ItemUi)
    }

    interface Change {
        fun delete(item: ItemUi)
        fun update(item: ItemUi)
    }


    interface Mutable : Update, Read
    interface All : Mutable, Add, Change
    class Base : All {

        private val liveData = MutableLiveData<List<ItemUi>>()
        override fun update(list: List<ItemUi>) {
            liveData.value = list
        }

        override fun update(item: ItemUi) {
            val list = liveData.value?.toMutableList() ?: ArrayList()
            list.find { it.areItemsSame(item) }?.let {
                list[list.indexOf(it)] = item
            }
            update(list)
        }

        override fun liveData(): LiveData<List<ItemUi>> {
            return liveData
        }

        override fun add(value: ItemUi) {
            val list = liveData.value?.toMutableList() ?: ArrayList()
            list.add(value)
            update(list)
        }
        override fun delete(item: ItemUi) {
            val list = liveData.value?.toMutableList() ?: ArrayList()
            list.remove(item)
            update(list)
        }
    }
}