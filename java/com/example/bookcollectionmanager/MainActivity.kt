// MainActivity placeholder
// Student ID: 2024EB01088

package com.example.bookcollectionmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)

        val title = findViewById<EditText>(R.id.etTitle)
        val author = findViewById<EditText>(R.id.etAuthor)

        val save = findViewById<Button>(R.id.btnSave)
        val view = findViewById<Button>(R.id.btnView)

        save.setOnClickListener {

            if (title.text.toString().isEmpty() || author.text.toString().isEmpty()) {

                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()

            } else {

                val result = db.insertBook(
                    title.text.toString(),
                    author.text.toString()
                )

                if (result) {

                    Toast.makeText(this, "Book Saved Successfully", Toast.LENGTH_SHORT).show()

                    title.text.clear()
                    author.text.clear()

                } else {

                    Toast.makeText(this, "Error Saving", Toast.LENGTH_SHORT).show()

                }

            }

        }

        view.setOnClickListener {

            startActivity(Intent(this, BookListActivity::class.java))

        }

    }
}
