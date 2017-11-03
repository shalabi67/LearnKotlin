package com.learn

fun main(args:Array<String>) {
    runVoidFunction(action)

    var result = calculate(10, 20, multiplier)
    println("10 * 20 = $result")

    result = calculate(10, 20, add)
    println("10 + 20 = $result")

}


val action = {println("Hello, world")}

fun runVoidFunction(function: () -> Unit) {
    function()
}

val multiplier = {x:Int, y:Int -> x * y}
val add :(Int, Int) -> Int = {x, y -> x + y}
fun calculate(x:Int,
              y:Int,
              computationFunction: (Int, Int) -> Int
):Int {
    return computationFunction(x, y)
}

