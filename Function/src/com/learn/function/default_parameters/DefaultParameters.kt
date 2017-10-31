package com.learn.function.default_parameters

/**
 * Created by mohammad on 10/31/2017.
 */

fun log(message:String, logLevel:Int=0) {
    var beginPart = when(logLevel) {
        1 -> "Debug"
        2 -> "Warn"
        3 -> "Error"
        4 -> "Exception"
        else -> "Info"
    }

    println("$beginPart \t\t$message")
}

fun show(firstName:String = "", lastName:String="", phoneNumber:String="") {
    var message = if(firstName.length != 0) "first name is $firstName" else ""
    message +=  if(lastName.length != 0) "\nlast name is $lastName" else ""
    message +=  if(phoneNumber.length != 0) "\nphone number is $phoneNumber" else ""

    println(message)
}