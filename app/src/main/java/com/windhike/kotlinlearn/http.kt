package com.windhike.kotlinlearn

import android.util.Log
import java.net.URL

/**
 * author: gzzyj on 2017/1/18.
 * email:zhyongjun@windhike.cn
 */
public class Request(val url:String){
    public fun run():String{
        val result = URL(url).readText()
        Log.e(javaClass.simpleName,"=====request url $result")
        return result
    }
}

//get
//{
//    "args": {},
//    "headers": {
//    "Accept-Encoding": "gzip",
//    "Host": "httpbin.org",
//    "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 5.1.1; Mi-4c MIUI/V8.0.5.0.LXKCNDG)"
//},
//    "origin": "14.18.25.170",
//    "url": "http://httpbin.org/get"
//}