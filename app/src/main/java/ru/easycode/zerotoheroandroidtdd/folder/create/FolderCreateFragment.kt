package ru.easycode.zerotoheroandroidtdd.folder.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentCreateFolderBinding

class FolderCreateFragment: AbstractFragment<FragmentCreateFolderBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?)  =
        FragmentCreateFolderBinding.inflate(inflater, container, false)
    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {
        super.onViewCreated(view, saveInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(FolderCreateViewModel::class.java)

        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = viewModel.comeback()
        })

        binding.createFolderEditText.addTextChangedListener {
            binding.saveFolderButton.isEnabled = binding.createFolderEditText.text.toString().length >= 3
        }

        binding.saveFolderButton.setOnClickListener {
            hideKeyboard()
            viewModel.add(binding.createFolderEditText.text.toString())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        //onBackPressedCallback.remove()
    }
}