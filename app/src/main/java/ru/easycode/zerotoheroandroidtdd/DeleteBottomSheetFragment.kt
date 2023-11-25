package ru.easycode.zerotoheroandroidtdd

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class DeleteBottomSheetFragment: BottomSheetDialogFragment(R.layout.delete_layout) {
    companion object {
        fun newInstance(itemId: Long): DeleteBottomSheetFragment {
            val instance = DeleteBottomSheetFragment()
            instance.arguments = Bundle().apply {
                putLong(KEY, itemId)
            }
            return instance
        }

        private const val KEY = "itemIdToDelete"
    }
    private lateinit var viewModel: DeleteViewModel
    private lateinit var onBackPressedCallback: OnBackPressedCallback

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(DeleteViewModel::class.java)
        onBackPressedCallback = object: OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                viewModel.comeback()
                dismiss()
            }
        }
        (dialog as BottomSheetDialog).onBackPressedDispatcher.addCallback(onBackPressedCallback)
        return dialog
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(DeleteViewModel::class.java)
        val itemId = requireArguments().getLong(KEY)
        val button = view.findViewById<Button>(R.id.deleteButton)
        button.setOnClickListener {
            viewModel.delete(itemId)
            dismiss()
        }
        val textView = view.findViewById<TextView>(R.id.itemTitleTextView)
        view.findViewById<View>(R.id.saveButton).setOnClickListener {
            viewModel.liveData.observe(viewLifecycleOwner) {
                textView.text = it
            }
        }
        viewModel.init(itemId)
    }
}