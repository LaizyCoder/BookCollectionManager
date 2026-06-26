// DatabaseHelper placeholder
// Student ID: 2024EB01088

package com.example.bookcollectionmanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "BookDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = """
            CREATE TABLE Books(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT,
            author TEXT
            )
        """

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Books")
        onCreate(db)
    }

    fun insertBook(title: String, author: String): Boolean {

        val db = writableDatabase
        val values = ContentValues()

        values.put("title", title)
        values.put("author", author)

        val result = db.insert("Books", null, values)

        return result != -1L
    }

    fun getAllBooks(): ArrayList<Book> {

        val list = ArrayList<Book>()

        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM Books", null)

        if (cursor.moveToFirst()) {

            do {

                list.add(
                    Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                    )
                )

            } while (cursor.moveToNext())
        }

        cursor.close()

        return list
    }

}
