package com.example.hafez.omen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.hafez.R

class TakeOmenFragment : Fragment() {
    private lateinit var showBubble: ImageView
    private lateinit var commentBubble: ImageView
    private lateinit var commentHeart: ImageView
    private lateinit var comment: EditText
    private lateinit var interpretation: TextView
    private lateinit var navController: NavController
    var isClicked = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.take_omen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBubble = view.findViewById(R.id.showBubble)
        commentBubble = view.findViewById(R.id.commentBubble)
        commentHeart = view.findViewById(R.id.commentHeart)
        comment = view.findViewById(R.id.commentEditText)
        interpretation = view.findViewById(R.id.omenInterpretation)
        navController = Navigation.findNavController(view)



        commentBubble.visibility = View.GONE
        commentHeart.visibility = View.GONE
        comment.visibility = View.GONE

        showBubble.setOnClickListener {
            if (commentBubble.visibility == View.GONE) {
                showBubble.setImageResource(R.drawable.here_pressed)
                commentBubble.visibility = View.VISIBLE
                commentHeart.visibility = View.VISIBLE
                comment.visibility = View.VISIBLE
            } else {
//                showBubble.setImageResource(R.drawable.here)
                commentBubble.visibility = View.GONE
                commentHeart.visibility = View.GONE
                comment.visibility = View.GONE
//                commentHeart.setImageResource(R.drawable.favorite)
            }
        }

        commentHeart.setOnClickListener {
            isClicked = if (!isClicked) {
                commentHeart.setImageResource(R.drawable.favorite_pressed)
                true
            } else {
                commentHeart.setImageResource(R.drawable.favorite)
                false
            }
        }

        interpretation.setOnClickListener {
            navController.navigate(R.id.action_takeOmenFragment_to_interpretationFragment)
        }
    }
}