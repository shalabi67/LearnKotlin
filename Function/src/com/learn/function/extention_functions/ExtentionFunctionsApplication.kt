package com.learn.function.extention

import com.learn.function.extention_functions.removeWhileSpaces

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    println("Add an extention function to String")
    var message = "This     is    \t    my    \n Message"
    println(message.removeWhileSpaces())
}