package ru.easycode.zerotoheroandroidtdd.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface FoldersDao {
    @Query("SELECT * FROM folders_table")
    fun list(): List<FolderCache>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: FolderCache)
    @Query("SELECT * FROM folders_table WHERE id = :id")
    fun item(id: Long): FolderCache
    @Query("DELETE FROM folders_table WHERE id = :id")
    fun delete(id: Long)
}