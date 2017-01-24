package com.windhike.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.windhike.kotlinlearn.domain.command.RequestForecastCommand
import com.windhike.kotlinlearn.http.loge
import com.windhike.kotlinlearn.model.Forecast
import com.windhike.kotlinlearn.model.ModelForecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHello.text = " 天气数据${getMyName()}"
        tvHello.setOnClickListener {

        }
        rvRecycler.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    private fun fetchData() = async() {
        val command = RequestForecastCommand("41000")
        val result = command.excute()
        uiThread {
            rvRecycler.adapter = TextListAdapter(result,object : OnItemClickListener{
                override fun invoke(forecast: ModelForecast) {
                    showToast("item was clicked")
                }
            })
        }
    }
}
fun AppCompatActivity.getMyName():String = this.javaClass.simpleName.toString()
fun AppCompatActivity.showToast(msg:String) = Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()


