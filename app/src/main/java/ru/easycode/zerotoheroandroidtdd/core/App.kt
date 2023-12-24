package ru.easycode.zerotoheroandroidtdd.core

import android.app.Application
import androidx.room.Room

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val database: AppDatabase by lazy {
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "database"
            ).build()
        }
    }
}