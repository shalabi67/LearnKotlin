package com.learn.static_object

open class Student(val id:Int, var firstName:String, var lastName:String) {
    var studentCourse = arrayListOf<Course>()
    fun enrol(courseName : String) {
        var course = Courses.getCourse(courseName)
        if(course != null) {
            studentCourse.add(course)
        }
    }

    fun display() {
        println("id:$id  firstName:$firstName  lastname:$lastName")
        print("courses: ")
        for(course in this.studentCourse) {
            course.dispaly()
        }
    }

    companion object {
        fun createUnderGraduateStudent(id:Int, firstName:String, lastName:String) : UnderGraduate {
            return UnderGraduate(id, firstName, lastName)
        }
        fun createPostGraduateStudent(id:Int, firstName:String, lastName:String) : PostGraduate {
            return PostGraduate(id, firstName, lastName)
        }
    }

}

class UnderGraduate(id:Int, firstName:String, lastName:String) :
        Student(id, firstName, lastName) {}

class PostGraduate(id:Int, firstName:String, lastName:String) :
        Student(id, firstName, lastName) {}