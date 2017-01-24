package com.windhike.kotlinlearn.http

import android.util.Log
import com.google.gson.Gson
import com.windhike.kotlinlearn.model.ForecastResult
import java.net.URL


/**
 * author: zyongjun on 2017/1/21 0021.
 * email: zhyongjun@windhike.cn
 */
class ForcastByZipcodeRequest(val zipcode:String,val gson: Gson = Gson()){
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }
    fun request():ForecastResult {
        val json:String = URL(COMPLETE_URL+zipcode).readText()
        return gson.fromJson(json, ForecastResult::class.java)
    }

}

fun Any.loge(msg:String){
    Log.e(javaClass.simpleName,msg)
}