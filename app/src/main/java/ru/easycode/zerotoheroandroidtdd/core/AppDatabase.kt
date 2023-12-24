package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [FolderCache::class, NoteCache::class], version = 1)
abstract class AppDatabase(context: Context): RoomDatabase() {

    abstract fun foldersDao(): FoldersDao
    abstract fun notesDao(): NotesDao
}
