package ru.easycode.zerotoheroandroidtdd.core


import android.widget.TextView

class FolderUi(private val id: Long, private val text: String) {
    fun areItemsSame(other: FolderUi) = id == other.id
    fun delete(deleteItemUi: DeleteItemUi) = deleteItemUi.delete(id)
    fun show(textView: TextView) = textView.setText(text)
}