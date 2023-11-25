package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView

class ItemUi(private val id: Long, private val text: String) {
    fun areItemSame(other: ItemUi) = id == other.id
    fun delete(deleteItemUi: DeleteItemUi) = deleteItemUi.delete(id)
    fun show(textView: TextView) = textView.setText(text)
}