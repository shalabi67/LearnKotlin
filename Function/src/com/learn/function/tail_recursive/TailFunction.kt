package com.learn.function.tail_recursive

import java.math.BigInteger

/**
 * Created by mohammad on 10/31/2017.
 */
fun fibo(number:Int,
         startNumber:BigInteger= BigInteger("0"),
         nextNumber:BigInteger= BigInteger("1")
):BigInteger {
    return if(number == 0) return startNumber else fibo(number -1 , nextNumber, startNumber + nextNumber)
}

tailrec fun tail_fibo(number:Int,
         startNumber:BigInteger= BigInteger("0"),
         nextNumber:BigInteger=BigInteger("1")
):BigInteger {
    return if(number == 0) return startNumber else tail_fibo(number -1 , nextNumber, startNumber + nextNumber)
}