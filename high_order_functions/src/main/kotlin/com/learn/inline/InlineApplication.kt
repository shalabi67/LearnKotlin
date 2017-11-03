package com.learn.inline


fun main(args : Array<String>) {
    val list = listOf("mohammad", "shalabi", "ovidio", "ahmad", "aurel", "julia", "shalabi", "julia")
    val isShalabi = {name:String -> name == "shalabi"}
    val shalabi = first(list, {name -> name == "shalabi"})
    val shalabi2 = first(list, isShalabi)
    val shalabi1 = firstNoSequence(list, {name -> name == "shalabi"})
    println(shalabi)

    for(i in 1 ..20) {
        val shalabi = first(list, {name -> name == "shalabi"})
    }

    for(i in 1 ..20) {
        val shalabi = first(list, isShalabi)
    }
}

fun <T> first(items:List<T>,
              predicate:(T) -> Boolean
) : T {
    val item : T = items.asSequence().filter(predicate).first()
    return item
}

inline fun <T> firstNoSequence(items:List<T>,
              predicate:(T) -> Boolean
) : T  {
    for(item in items) {
        if(predicate(item))
            return item
    }
    throw Exception()
}