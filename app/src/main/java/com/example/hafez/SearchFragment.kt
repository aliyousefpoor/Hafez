package com.example.hafez

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SearchFragment : Fragment() {
    private lateinit var close: ImageView
    private lateinit var search: EditText
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        close = view.findViewById(R.id.closeSearch)
        search = view.findViewById(R.id.searchEditText)
        navController = Navigation.findNavController(view)

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                close.setImageResource(R.drawable.close)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                close.setImageResource(R.drawable.close)
            }
        })

        close.setOnClickListener {
            search.text.clear()
            close.setImageResource(R.color.white)
        }
    }
}