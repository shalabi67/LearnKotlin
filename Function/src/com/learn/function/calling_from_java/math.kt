@file:JvmName("MathFunctions")
package com.learn.function.calling_from_java

/**
 * Created by mohammad on 10/31/2017.
 */

fun intSum(arg1:Int, arg2:Int):Int {
    return arg1 + arg2
}

fun sum(arg1:Int, arg2:Int):Int = arg1 + arg2

fun max(arg1:Int, arg2:Int):Int = if(arg1>arg2) arg1 else arg2