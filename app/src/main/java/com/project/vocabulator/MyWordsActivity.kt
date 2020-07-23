package com.project.vocabulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_words.*

class MyWordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words)

        val tinyDB=TinyDB(this);
        val words= tinyDB.getListString("Words");
        val adapter=WordAdapter(this, words.size)

        recycler_view.adapter=adapter
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}
