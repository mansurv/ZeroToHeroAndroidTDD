package ru.easycode.zerotoheroandroidtdd

interface Repository {
    interface ReadItem {
        fun item(id: Long): Item
    }
    interface ChangeItem {
        fun update(id: Long, newText: String)
        fun delete(id: Long)
    }
    interface Read {
        fun list(): List<Item>
    }
    interface Add {
        fun add(value: String): Long
    }
    interface Mutable: Read, Add
    interface Change: ReadItem, ChangeItem
    interface All: Mutable, Change
    class Base(
        private val dataSource: ItemsDao,
        private val now: Now
    ): All {
        override fun list(): List<Item> {
            return dataSource.list().map { Item(it.id, it.text) }
        }
        override fun add(value: String): Long {
            val id = now.nowMillis()
            dataSource.add(ItemCache(id, value))
            return id
        }
        override fun item(id: Long): Item {
            val itemCache = dataSource.item(id)
            return Item(itemCache.id, itemCache.text)
        }
        override fun delete(id:Long) {
            dataSource.delete(id)
        }
        override fun update(id:Long, newText: String) {
            val current = dataSource.item(id)
            val new = current.copy(text = newText)
            dataSource.add(new)
        }
    }
}

data class Item(val id: Long, val text: String)