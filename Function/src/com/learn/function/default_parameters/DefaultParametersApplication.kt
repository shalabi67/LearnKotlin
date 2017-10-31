package com.learn.function.default_parameters

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    log("This is an info message")
    log("This is a debug message", 1)

    show(phoneNumber = "123")
    show(lastName = "shalabi", phoneNumber = "123")
    show(firstName = "mohammad", phoneNumber = "123")
    show()
    show(phoneNumber = "123", firstName = "mohammad", lastName = "shalabi")
}