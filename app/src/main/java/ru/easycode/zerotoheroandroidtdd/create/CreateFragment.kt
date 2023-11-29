package ru.easycode.zerotoheroandroidtdd.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentCreateBinding

class CreateFragment: AbstractFragment<FragmentCreateBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?)  =
        FragmentCreateBinding.inflate(inflater, container, false)
    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {
        super.onViewCreated(view, saveInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(CreateViewModel::class.java)

        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = viewModel.comeback()
        })

        binding.inputEditText.addTextChangedListener {
            binding.createButton.isEnabled = binding.inputEditText.text.toString().length >= 3
        }

        binding.createButton.setOnClickListener {
            hideKeyboard()
            viewModel.add(binding.inputEditText.text.toString())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        //onBackPressedCallback.remove()
    }
}