package com.learn.nulls

/**
 * Created by mohammad on 10/31/2017.
 */
class Person {
    var firstName=""
    var lastName:String?=null
    var parent:Person?=null

    fun display() {
        println("************************")
        val last = if(lastName != null) lastName else ""
        println("The name is $firstName $last")
        println("The parent is ")
        parent?.display()
        println("*************************")
    }
}