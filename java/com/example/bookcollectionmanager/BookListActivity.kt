// BookListActivity placeholder

// Student ID: 2024EB01088

package com.example.bookcollectionmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        recycler.layoutManager = LinearLayoutManager(this)

        val db = DatabaseHelper(this)

        recycler.adapter = BookAdapter(db.getAllBooks())

    }

}
