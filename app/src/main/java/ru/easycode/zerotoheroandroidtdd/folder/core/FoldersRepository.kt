package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.core.FolderCache
import ru.easycode.zerotoheroandroidtdd.core.FoldersDao
import ru.easycode.zerotoheroandroidtdd.folder.core.Folder

interface FoldersRepository {
    interface ReadFolder {
        fun item(id: Long): Folder
    }
    interface ChangeFolder {
        fun update(id: Long, newText: String)
        fun delete(id: Long)
    }
    interface Read {
        fun list(): List<Folder>
    }
    interface Add {
        fun add(value: String): Long
    }
    interface Mutable: Read, Add
    interface Change: ReadFolder, ChangeFolder
    interface All: Mutable, Change
    class Base(
        private val dataSource: FoldersDao,
        private val now: Now
    ): All {
        override fun list(): List<Folder> {
            return dataSource.list().map { Folder(it.id, it.text) }
        }
        override fun add(value: String): Long {
            val id = now.nowMillis()
            dataSource.add(FolderCache(id, value))
            return id
        }
        override fun item(id: Long): Folder {
            val itemCache = dataSource.item(id)
            return Folder(itemCache.id, itemCache.text)
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
