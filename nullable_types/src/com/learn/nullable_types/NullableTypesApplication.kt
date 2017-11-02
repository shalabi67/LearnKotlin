package com.learn.nullable_types

import com.learn.nullable_types.meeting.Address
import com.learn.nullable_types.meeting.ISaveable
import com.learn.nullable_types.meeting.Meeting
import com.learn.nullable_types.meeting.SaveableObject

class NullableTypesApplication {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            var nullableMeeting : Meeting? = null
            var meeting =Meeting(true)


            //every time we want to call close meeting with nullable meeting we need to convert it to non nullable object
            //this means that the disition of nullability is at the caller side.
            closeMeeting(nullableMeeting?:Meeting())
            nullableMeeting?.let { closeMeeting(nullableMeeting) }
            closeMeeting(meeting)

            //in this case f the nullable meeting is null the framework with throw an exception
            //closeMeeting(nullableMeeting!!)  //this code will assert


            //in this case we can pass nullable meetings but the method need to handle the nullability issue and the
            // caller had no control on what the method to do if the value is null.
            //closeAssertionNullableMeeting(nullableMeeting)  // the method will assert
            closeAssertionNullableMeeting(meeting)


            //in this case we can pass nullable meetings but the method need to handle the nullability issue and the
            // caller had no control on what the method to do if the value is null.
            closeNullableMeeting(nullableMeeting)  //this solution may cause side effects.
            closeNullableMeeting(meeting)

            val saveableObject = SaveableObject()
            save(saveableObject)
            //save(meeting)  //this function will cause casting exception

            safeSave(saveableObject)
            safeSave(meeting)  //no exception will be thrown.

            meeting.address= Address("löwen", "berlin", "germany")

        }
    }
}
fun closeMeeting(meeting: Meeting) : Boolean {
    if(meeting.canClose) {
        return meeting.close()
    }

    return false;
}

fun closeNullableMeeting(meeting: Meeting?) : Boolean {
    if(meeting?.canClose == true) {
        return meeting.close()
    }

    return false;
}
fun closeAssertionNullableMeeting(meeting: Meeting?) : Boolean {
    if(meeting!!.canClose) {
        return meeting.close()
    }

    return false;
}

fun save(objectToSave : Any) {
    val savableObject = objectToSave as ISaveable
    savableObject.save()
}

fun safeSave(objectToSave : Any) {
    val savableObject = objectToSave as? ISaveable
    savableObject?.save()
}