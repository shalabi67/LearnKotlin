package com.learn.function.infix_functions

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    var h1 = HtmlHeader("H1")
    var h2 = HtmlHeader("H2")

    var h1h2 = h1 add h2
    println(h1h2.name)

    var h1h2h1 = h1h2 + h1
    println(h1h2h1.name)
}