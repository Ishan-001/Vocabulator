package com.project.vocabulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var type:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val Types=resources.getStringArray(R.array.Type)
        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, Types)
        spinner.adapter=adapter

        spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                type=Types[position]
            }
        }
        add_word.setOnClickListener {
            val word=word.text.toString().trim()
            val des=des.text.toString().trim()

            val tinyDB=TinyDB(baseContext)
            val words=tinyDB.getListString("Words")
            val descriptions=tinyDB.getListString("Descriptions")
            val types=tinyDB.getListString("Types")

            words.add(word)
            descriptions.add(des)
            types.add(type)

            tinyDB.putListString("Words",words)
            tinyDB.putListString("Descriptions",descriptions)
            tinyDB.putListString("Types",types)

            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
