package com.example.hafez.search

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import java.util.*

class SearchFragment : Fragment() {
    private lateinit var close: ImageView
    private lateinit var search: EditText
    private lateinit var navController: NavController
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchAdapter
    private lateinit var meanText: TextView
    private lateinit var meanCount: TextView
    private var searchItem: MutableList<String> = ArrayList()

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
        recyclerView = view.findViewById(R.id.searchRecyclerView)
        meanText = view.findViewById(R.id.example)
        meanCount = view.findViewById(R.id.meanCount)

        search.addTextChangedListener(object : TextWatcher {
            val handler = Handler(Looper.getMainLooper())

            override fun afterTextChanged(s: Editable?) {
                close.setImageResource(R.drawable.close)
                highLight(s.toString())
                val runnable = Runnable {
                    filterWord(s.toString())
                }
                handler.postDelayed(runnable, 3000)
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

        val arrayList: MutableList<String> = ArrayList()
        adapter = SearchAdapter(arrayList, requireContext())
        recyclerView.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager
    }


    private fun filterWord(stringList: String) {

        if (meanText.text.toString().contains(stringList, true)) {
            searchItem.add(stringList)
        }
        adapter.updateList(searchItem)
    }

    fun highLight(string: String) {

        val replaceWith = "<span style ='background-color:yellow'>$string</span>"
        val originalText = meanText.text.toString()
        val modifiedText = originalText.replace(string.toRegex(), replaceWith)
        meanText.text = Html.fromHtml(modifiedText)
    }


}