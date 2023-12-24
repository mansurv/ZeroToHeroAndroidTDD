package ru.easycode.zerotoheroandroidtdd.folder.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.easycode.zerotoheroandroidtdd.core.FoldersDao

class FoldersRepository(private val foldersDao: FoldersDao) {
    suspend fun insertNewFolder() {
        withContext(Dispatchers.IO) {
            foldersDao.add(item: FolderCache)
        }
    }
}