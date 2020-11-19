package com.example.hafez.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.hafez.R

class RemoveDialogFragment:DialogFragment() {
    private lateinit var cancel: Button
    private lateinit var removeNote: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.remove_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancel = view.findViewById(R.id.cancel)
        removeNote = view.findViewById(R.id.removeNote2)


        cancel.setOnClickListener {
            Toast.makeText(requireContext(), "منصرف شدید !", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        removeNote.setOnClickListener {
            Toast.makeText(requireContext(), "یادداشت پاک شد", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}