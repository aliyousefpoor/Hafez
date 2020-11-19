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

class NotesDialogFragment : DialogFragment() {
    private lateinit var closeNote: ImageView
    private lateinit var notesEditText: EditText
    private lateinit var saveNote: Button
    private lateinit var removeNote: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notes_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closeNote = view.findViewById(R.id.closeNotesDialog)
        notesEditText = view.findViewById(R.id.notesDialogEditText)
        saveNote = view.findViewById(R.id.saveNote)
        removeNote = view.findViewById(R.id.removeNote)

        closeNote.setOnClickListener {
            dismiss()
        }
        saveNote.setOnClickListener {
            Toast.makeText(requireContext(), "یادداشت ذخیره شد", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        removeNote.setOnClickListener {
            val removeDialogFragment = RemoveDialogFragment()
            removeDialogFragment.show(parentFragmentManager, "RemoveDialogFragment")
        }
    }
}