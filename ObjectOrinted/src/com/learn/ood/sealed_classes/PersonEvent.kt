package com.learn.ood.sealed_classes

/**
 * Created by mohammad on 10/31/2017.
 */
sealed class PersonEvent {
    class Aweak : PersonEvent()
    class Asleep : PersonEvent()
    class Eating(val food:String) : PersonEvent()
}

fun handlePersonEvent(event: PersonEvent) {
    when(event) {
        is PersonEvent.Aweak -> println("aweak")
        is PersonEvent.Asleep -> println("asleep")
        is PersonEvent.Eating -> println(event.food)
    }
}