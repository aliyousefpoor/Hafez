package com.example.hafez.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hafez.R

class SearchAdapter(private var arrayList: MutableList<String>, private var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.search_adapter, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val searchViewHolder: SearchViewHolder = holder as SearchViewHolder
        searchViewHolder.onBind(arrayList)
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val searchText: TextView = itemView.findViewById(R.id.searchText)
        fun onBind(text: MutableList<String>) {
            searchText.text = text[position]
            text.clear()
        }
    }

    fun updateList(list: MutableList<String>) {
        arrayList = list
        notifyDataSetChanged()
    }
}