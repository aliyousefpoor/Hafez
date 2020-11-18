package com.example.hafez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class NoteFragment:Fragment() {
    private lateinit var goToTurnPage: ImageView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToTurnPage = view.findViewById(R.id.goToPager)
        navController = Navigation.findNavController(view)

        goToTurnPage.setOnClickListener {
            navController.navigate(R.id.action_noteFragment2_to_turnPageFragment4)
        }
    }
}