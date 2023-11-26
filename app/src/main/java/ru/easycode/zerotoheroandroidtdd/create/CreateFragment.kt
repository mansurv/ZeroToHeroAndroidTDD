package ru.easycode.zerotoheroandroidtdd.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CreateFragment: AbstactFragment<FragmentCreateBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?)  =
        FragmentCreateBinding.inflate(inflater, container, false)
    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {
        super.onViewCreated(view, saveInstanceState)
    }
}