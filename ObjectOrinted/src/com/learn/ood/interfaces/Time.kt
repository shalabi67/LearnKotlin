package com.learn.ood.interfaces

/**
 * Created by mohammad on 10/31/2017.
 */
interface Time {
    fun setTime(hour:Int, min:Int=0, sec:Int=0)
    fun setTime(time:KevinTime) = setTime(time.hour, time.min, time.sec)
}
interface Time2 {
    //fun setTime(hour:Int, min:Int=0, sec:Int=0)
    fun setTime(time:KevinTime) {}
}
class KevinTime {
    var hour:Int = 0
    var min:Int=0
    var sec:Int=0
}
class YetiTime : Time, Time2 {
    override fun setTime(hour:Int, min:Int, sec:Int) {

    }
    override fun setTime(time:KevinTime) {
        super<Time>.setTime(time)
    }
}