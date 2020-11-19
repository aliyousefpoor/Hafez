package com.example.hafez.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hafez.R

class NotesFragment:Fragment(){
private lateinit var noteDialog:Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteDialog = view.findViewById(R.id.goToNote)

        noteDialog.setOnClickListener {
            val notesDialogFragment =NotesDialogFragment()
            notesDialogFragment.show(parentFragmentManager,"NotesDialogFragment")
        }
    }
}