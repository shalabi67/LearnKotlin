package com.learn.static_object

class ObjectApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var mohammad = Student(1, "mohammad", "shalabi")
            mohammad.enrol("math101")

            mohammad.display()
        }
    }

}