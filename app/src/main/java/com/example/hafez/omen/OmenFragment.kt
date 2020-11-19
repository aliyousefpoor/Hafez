package com.example.hafez.omen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.hafez.R

class OmenFragment : Fragment() {
    private lateinit var goToTurnPage: ImageView
    private lateinit var navController: NavController
    private lateinit var takeOmen: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.omen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToTurnPage = view.findViewById(R.id.showBubble)
        takeOmen = view.findViewById(R.id.takeOmen)
        navController = Navigation.findNavController(view)

        goToTurnPage.setOnClickListener {
            navController.navigate(R.id.action_omenFragment2_to_turnPageFragment5)
        }
        takeOmen.setOnClickListener {
            navController.navigate(R.id.action_omenFragment2_to_takeOmenFragment)
        }
    }
}