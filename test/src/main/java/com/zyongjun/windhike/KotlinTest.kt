package com.zyongjun.windhike

fun main(args:Array<String>) {
    val t= MyTest("joe","mother")
    println(t.transform(t.name, String::toUpperCase))
}

class  MyTest(var name:String,parent:String){

}

fun MyTest.transform(t:String,func:(String)->String) :String{
    return func(t)
}