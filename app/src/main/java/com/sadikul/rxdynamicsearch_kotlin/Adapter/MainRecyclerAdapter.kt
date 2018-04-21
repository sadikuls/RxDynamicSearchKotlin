package com.sadikul.rxdynamicsearch_kotlin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.sadikul.rxdynamicsearch_kotlin.Model.SearchItem
import com.sadikul.rxdynamicsearch_kotlin.R
import java.util.*

class MainRecyclerAdapter(private val context: Context, list: MutableList<SearchItem>) : RecyclerView.Adapter<MainRecyclerAdapter.MainAdapterViewHolder>() {

    override fun getItemCount(): Int {

        return list.size
    }

    private val inflater: LayoutInflater
    internal var list: MutableList<SearchItem> = mutableListOf()


    init {
        this.list = list
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {

        val view = inflater.inflate(R.layout.item_search_layout, parent, false)
        val mainAdapterViewHolder = MainAdapterViewHolder(view)
        return MainAdapterViewHolder(view)
    }

    fun setData(list: MutableList<SearchItem>) {
        this.list.clear()
        this.list = list
        //this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {

        val NoticeItem = list.get(position)
        holder.name.setText(NoticeItem.getTitle())
        holder.age.setText(NoticeItem.getDescript())

    }

    fun clear() {
        this.list.clear()
        notifyDataSetChanged()
    }

    inner class MainAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var name: TextView
        internal var age: TextView

        init {
            name = itemView.findViewById(R.id.name)
            age = itemView.findViewById(R.id.age)
        }
    }
}