package com.learn.ood.classes

/**
 * Created by mohammad on 10/31/2017.
 */
open class Person : Human() {
    var firstName = ""
    var lastName = ""

    open fun getFullName():String = "$firstName $lastName"
    override fun getAddress() : String {
        return "This is the address"
    }
}