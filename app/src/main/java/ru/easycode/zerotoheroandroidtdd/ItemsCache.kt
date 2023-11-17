package ru.easycode.zerotoheroandroidtdd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table" )
data class ItemsCache (
  @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "text") val text: String
)