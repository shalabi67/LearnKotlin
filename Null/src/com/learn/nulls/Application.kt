package com.learn.nulls

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    println("you can not assing a null value like q=null.")
    //var message:String=null
    println("to force null use question mark. and to use it you need to specify the question mark.")
    var message:String? = null
    message = "hello"
    println("the message is $message")

    println("null with classes")
    var adam = Person()
    adam.firstName="Adam";
    adam.display()

    var qabeel = Person()
    qabeel.firstName="qabeel"
    qabeel.lastName="adam";
    qabeel.parent = adam;
    qabeel.display()



}