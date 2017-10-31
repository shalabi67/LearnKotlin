package com.learn.function

/**
 * Created by mohammad on 10/31/2017.
 */

fun main(args:Array<String>) {
    display("hello world")
    println("The sum of 5, 6  is ${intSum(5,6)}")
    println("The sum of 5, 6  is ${sum(5,6)}")
    println("The max of 5, 6  is ${max(5,6)}")

}
fun display(message:String) {
    println(message)
}
fun intSum(arg1:Int, arg2:Int):Int {
    return arg1 + arg2
}

fun sum(arg1:Int, arg2:Int):Int = arg1 + arg2

fun max(arg1:Int, arg2:Int):Int = if(arg1>arg2) arg1 else arg2