package com.example.hafez.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.hafez.R

class SignDialogFragment:DialogFragment() {
    private lateinit var closeSign: ImageView
    private lateinit var notesEditText: EditText
    private lateinit var saveSign: Button
    private lateinit var removeSign: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_dialog_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closeSign = view.findViewById(R.id.closeSignDialog)
        notesEditText = view.findViewById(R.id.notesDialogEditText)
        saveSign = view.findViewById(R.id.saveSign)
        removeSign = view.findViewById(R.id.removeSign)

        closeSign.setOnClickListener {
            dismiss()
        }
        saveSign.setOnClickListener {
            Toast.makeText(requireContext(), "نشانه ذخیره شد", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        removeSign.setOnClickListener {
            val removeDialogFragment = RemoveDialogFragment()
            removeDialogFragment.show(parentFragmentManager, "RemoveDialogFragment")
        }
    }
}