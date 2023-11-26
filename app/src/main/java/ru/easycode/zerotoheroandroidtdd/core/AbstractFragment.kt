package ru.easycode.zerotoheroandroidtdd.core

import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding.bind

abstract class AbstractFragment<B: ViewBinding> {
    protected val binding get() = _binding!!

            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstantState: Bundle?
            ): View {
                _binding = bind(inflater, container)
                return binding(root)
            }

    protected abstract fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): B

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
