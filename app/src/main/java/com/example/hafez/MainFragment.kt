package com.example.hafez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment : Fragment() {
    private lateinit var arrow: ImageView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrow = view.findViewById(R.id.arrow)
        navController = Navigation.findNavController(view)

        arrow.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_turnPageFragment)
        }
    }
}