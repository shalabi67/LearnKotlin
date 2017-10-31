package com.learn.ood.sealed_classes

/**
 * Created by mohammad on 10/31/2017.
 */
fun main(args:Array<String>) {
    var aweak = PersonEvent.Aweak()
    var asleep = PersonEvent.Asleep()
    var eating = PersonEvent.Eating("orange")

    handlePersonEvent(aweak)
    handlePersonEvent(asleep)
    handlePersonEvent(eating)
}