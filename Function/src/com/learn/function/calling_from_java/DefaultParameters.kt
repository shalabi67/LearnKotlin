@file:JvmName("Log")
package com.learn.function.calling_from_java

/**
 * Created by mohammad on 10/31/2017.
 */

@JvmOverloads
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