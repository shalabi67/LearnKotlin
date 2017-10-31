package com.learn.function.extention_functions

/**
 * Created by mohammad on 10/31/2017.
 */
fun String.removeWhileSpaces():String {
    var regx = Regex("\\s+")
    return regx.replace(this, " ")
}