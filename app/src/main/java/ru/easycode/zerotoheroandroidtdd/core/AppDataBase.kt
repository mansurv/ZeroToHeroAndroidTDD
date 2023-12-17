package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room

class AppDataBase(private val context: Context) {

    private val database by lazy {
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "folders_database"
        ).fallbackToDestructiveMigration().build()
    }
    fun dao() = database.foldersDao()
}