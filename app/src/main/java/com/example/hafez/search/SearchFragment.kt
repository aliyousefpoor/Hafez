package com.example.hafez.search

import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hafez.R
import java.util.ArrayList

class SearchFragment : Fragment() {
    private lateinit var close: ImageView
    private lateinit var searchIcon: ImageView
    private lateinit var search: EditText
    private lateinit var navController: NavController
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchAdapter
    private lateinit var meanText: TextView
    private lateinit var meanCount: TextView
    private lateinit var searchItem: MutableList<String>

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
        searchIcon = view.findViewById(R.id.searchIcon)
        search = view.findViewById(R.id.searchEditText)
        navController = Navigation.findNavController(view)
        recyclerView = view.findViewById(R.id.searchRecyclerView)
        meanText = view.findViewById(R.id.example)
        meanCount = view.findViewById(R.id.meanCount)

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                close.setImageResource(R.drawable.close)
//                filterWord(s.toString())
                highLight(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                close.setImageResource(R.drawable.close)
            }
        })

        close.setOnClickListener {
            search.text.clear()
            searchItem.clear()
            close.setImageResource(R.color.white)
        }

        searchIcon.setOnClickListener {

        }
        val arrayList: MutableList<String> = ArrayList()
        adapter = SearchAdapter(arrayList, requireContext())
        recyclerView.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager
    }


    fun filterWord(stringList: String) {

        searchItem = ArrayList()

        for (d in meanText.text.toString()) {
            if (stringList in d.toString()) {
                searchItem.add(d.toString())
            }
            if (search.text.isEmpty()) {
                meanCount.text = "0"
            } else {
                meanCount.text = searchItem.size.toString()
                adapter.updateList(searchItem)
            }
        }
    }

    fun highLight(string: String) {

        val replaceWith = "<span style ='background-color:yellow'>" + string + "</span>"
        val originalText = meanText.text.toString()
        val modifiedText = originalText.replace(string.toRegex(), replaceWith)
        meanText.text = Html.fromHtml(modifiedText)
    }


}