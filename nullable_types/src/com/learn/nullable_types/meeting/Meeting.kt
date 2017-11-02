package com.learn.nullable_types.meeting

class Meeting(var canClose : Boolean=false) {

    //lateinit can be used when we can not initialize a property at constrution time, and it will be initialized later
    // at the same time we do not want to initializd using null.
    lateinit var address : Address
    fun close() : Boolean {
        return true
    }
}