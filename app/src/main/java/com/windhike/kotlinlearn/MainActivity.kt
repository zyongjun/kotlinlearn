package com.windhike.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHello.text = " ${getMyName()}"
        tvHello.setOnClickListener {
            Toast.makeText(this,"print name ${getMyName()}",Toast.LENGTH_SHORT).show()
            toast("print name ${getMyName()}")
        }

        rvRecycler.layoutManager = LinearLayoutManager(this)
        val list = listOf("hello","world","lines","four")
        rvRecycler.adapter = TextListAdapter(list)
    }
}
fun AppCompatActivity.getMyName():String = this.javaClass.simpleName.toString()
