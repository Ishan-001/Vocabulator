package com.project.vocabulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_words.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }
        my_words.setOnClickListener { startActivity(Intent(this, MyWordsActivity::class.java)) }
    }
}
