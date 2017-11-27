package com.learn.reified

/**
 * Created by mohammad on 11/2/2017.
 */
fun main(args:Array<String>) {
    val stringList = listOf("mohammad", "shalabi")
    var intList = listOf(1,2,3)
    getTypes(stringList)
    getTypes(intList)  // this will combile but will throw an exception.
}

fun getTypes(items : List<Any>) {
    val stuff = items as List<String>
    stuff.filter{s -> s == ""}
}