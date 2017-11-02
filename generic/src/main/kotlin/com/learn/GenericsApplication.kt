package com.learn

import com.learn.data.DataNode
import com.learn.data.NumberData
import com.learn.data.StringData

/**
 * Created by mohammad on 11/2/2017.
 */
fun main(args:Array<String>) {
    val listString = listOf("mohammad", "shalabi")
    println(listString.itemAt(0))

    val stringNode = Node<String>("mohammad")
    println(stringNode.getItem())

    val stringData = StringData("mohammad")
    val intData = NumberData(4)
    val stringDataNode = DataNode<StringData>(stringData)
    val numberDataNode = DataNode<NumberData>(intData)
    //val canNotComnbile = DataNode<Int>(5)  //will not compile: will compile only for IData
}

//generic function to return an item at specific location
fun <T> List<T>.itemAt(index:Int) : T {
    return this[index]
}