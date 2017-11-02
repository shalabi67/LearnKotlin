package com.learn

fun main(args:Array<String>) {
    var people: List<Person> = listOf<Person>()
    var peopleNullable: List<Person?> = listOf<Person?>()
    var nullableList: List<Person>? = null
    var nullableListOfNullPersons: List<Person?>? = null

    var p1 = listOf(Person(1))  //list of person
    var p2 = listOf(Person(1), null)  //list of nullable person


    var list = listOf(Person(1), Person(2), null)
    //list.add(Person(4))  //add can not be used since it is not mutable
    for(person:Person? in list) {
        println("person id is ${person?.personId}")
    }
    for(person in list.filterNotNull()) {
        println("person id is ${person.personId}")
    }

    var list1 = mutableListOf(Person(1), Person(2), null)
    list1.add(Person(3))

}