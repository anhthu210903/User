package com.example.sqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addName = findViewById<Button>(R.id.add)
        val printName = findViewById<Button>(R.id.print)
        val personName = findViewById<EditText>(R.id.personName)
        val Name = findViewById<TextView>(R.id.Name)

        addName.setOnClickListener{


            val db = DBHelper(this, null)

            val name = personName.text.toString()

            db.addName(name)

            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()
            personName.text.clear()

        }

        printName.setOnClickListener {

            val db = DBHelper(this, null)
            val cursor = db.getName()

            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")

            while(cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")

            }

            cursor.close()
          
        }


    }



    }
