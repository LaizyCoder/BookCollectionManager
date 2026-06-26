// BookAdapter placeholder

// Student ID: 2024EB01088

package com.example.bookcollectionmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val list: ArrayList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.txtTitle)
        val author: TextView = itemView.findViewById(R.id.txtAuthor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)

        return BookViewHolder(view)

    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.title.text = list[position].title
        holder.author.text = list[position].author

    }

    override fun getItemCount(): Int {

        return list.size

    }

}
