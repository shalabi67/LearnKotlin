package com.learn.static_object

class Course(val id:Int, var title:String) {
    fun dispaly() {
        println("id: $id  title:$title")
    }
}
object Courses {
    var allCourses = arrayListOf<Course>()
    fun getCourse(courseName : String) : Course? {
        val course = Courses.allCourses
                .filter { it.title == courseName }
                .firstOrNull()

        return course
    }

    init {
        allCourses.add(Course(101, "math101"))
        allCourses.add(Course(102, "math102"))
        allCourses.add(Course(103, "math103"))
    }
}
