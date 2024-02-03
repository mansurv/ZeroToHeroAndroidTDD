package ru.easycode.zerotoheroandroidtdd.folder.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
//import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentFoldersListBinding

class FoldersListFragment: AbstractFragment<FragmentFoldersListBinding>() {
    private lateinit var viewModel: FoldersListViewModel
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentFoldersListBinding =
        FragmentFoldersListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {
        super.onViewCreated(view, saveInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(FoldersListViewModel::class.java)
        binding.addButton.setOnClickListener {
            viewModel.create()
        }
        val adapter = FoldersAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.liveData().observe(viewLifecycleOwner) {
            adapter.update(it)
        }
    }
}