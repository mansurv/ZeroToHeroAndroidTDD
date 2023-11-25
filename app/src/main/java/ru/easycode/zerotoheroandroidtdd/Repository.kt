package ru.easycode.zerotoheroandroidtdd

import com.netmontools.filesguide.ui.home.database.ItemCache
import com.netmontools.filesguide.ui.home.database.ItemsDao

interface Repository {

    interface Read {
        fun list(): List<String>
    }
    interface Add {
        fun add(value: String)
    }
    interface Mutable: Read, Add

    class Base(
        private val dataSource: ItemsDao,
        private val now: Now
    ): Mutable {
        override fun list(): List<String> {
            return dataSource.list().map {it.text}
        }

        override fun add(value: String) {
            dataSource.add(ItemCache(now.nowMillis(), value))
        }
    }
}