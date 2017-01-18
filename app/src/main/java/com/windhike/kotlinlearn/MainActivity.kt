package com.windhike.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHello.text = " ${getMyName()}"
        tvHello.setOnClickListener {
//            Toast.makeText(this,"print name ${getMyName()}",Toast.LENGTH_SHORT).show()
//            toast("print name ${getMyName()}")

            async() {
                val result = URL("http://httpbin.org/get").readText()
                uiThread {
                    Log.e(javaClass.simpleName,"==========================$result======")
                    tvHello.text = "result=$result"
                }
            }
        }

        rvRecycler.layoutManager = LinearLayoutManager(this)
        val list = listOf("hello","world","lines","four")
        rvRecycler.adapter = TextListAdapter(list)

        with(this){

        }
    }
}
fun AppCompatActivity.getMyName():String = this.javaClass.simpleName.toString()

//data class Headers(val Accept-Encoding:String,val Host:String,val User-Agent:String)


