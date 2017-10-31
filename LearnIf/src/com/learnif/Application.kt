package com.learnif

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    println("Example showing the use of if")
    val string1="hello"
    var string2="hello"
    if(string1 == string2)
        println("string1 equal string2")
    else
        println("string1 is not equal to string2")

    var message:String
    if(string1 == string2)
        message = "string1 equal string2"
    else
        message = "string1 is not equal to string2"

    println("$message")


    message = if(string1 == string2)
         "string1 equal string2"
    else
        "string1 is not equal to string2"

    println("$message")

}