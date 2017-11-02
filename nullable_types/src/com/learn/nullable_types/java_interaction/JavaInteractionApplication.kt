package com.learn.nullable_types.java_interaction

import com.learn.nullable_types.java_interaction.java.Meeting

fun main(args:Array<String>) {
    var javaMeeting = Meeting()

    var title : String? = javaMeeting.title;
    println(title);

    //var mayBeNullTitle:String = javaMeeting.titleCanBeNull  //the value is null so this will throw an exception
    //println(mayBeNullTitle)

    var mayBeNullTitle1:String? = javaMeeting.titleCanBeNull
    println(mayBeNullTitle1)

    //javaMeeting.setTitle(null)  //will not compile since it is define in java code as not nullable.
    javaMeeting.setTitle("aaaa")



}