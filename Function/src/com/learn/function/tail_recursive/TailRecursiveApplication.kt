package com.learn.function.tail_recursive

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    println(fibo(500))
    println(tail_fibo(500))

    try {
        println(fibo(10000))
    }catch(e:StackOverflowError) {
        println("fibo(10000) will cause stack overflow exception")

        println(tail_fibo(10000))
    }
}