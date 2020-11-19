package com.example.hafez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import app.num.numandroidpagecurleffect.PageCurlView
import java.util.ArrayList

class TurnPageFragment : Fragment() {
    private lateinit var pageCurlView: PageCurlView
    private lateinit var images: ArrayList<Int>
    private lateinit var pageNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.turn_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        pageCurlView = view.findViewById(R.id.turnPage)
//        pageNumber = view.findViewById(R.id.poemNumber)
//        images = ArrayList()
//
//        images.add(R.drawable.iran)
//        images.add(R.drawable.white)
//
//        pageCurlView.setCurlView(images)
//        pageCurlView.setCurlSpeed(600)
    }

}