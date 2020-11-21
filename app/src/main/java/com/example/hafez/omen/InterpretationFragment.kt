package com.example.hafez.omen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.hafez.R

class InterpretationFragment : DialogFragment() {
    private lateinit var close: ImageView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.interpretation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        close = view.findViewById(R.id.closeInterpretation)
//        navController = Navigation.findNavController(view)

        close.setOnClickListener {
//            navController.navigate(R.id.action_interpretationFragment_to_takeOmenFragment)
            dismiss()
        }
    }
}