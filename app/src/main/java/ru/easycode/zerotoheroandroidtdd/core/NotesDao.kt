package ru.easycode.zerotoheroandroidtdd.core

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface NotesDao {
    @Query("SELECT * FROM notes_table")
    fun list(): List<NoteCache>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: NoteCache)
    @Query("SELECT * FROM notes_table WHERE id = :id")
    fun item(id: Long): NoteCache
    @Query("DELETE FROM notes_table WHERE id = :id")
    fun delete(id: Long)
}