package com.learn.nullable_types.meeting

class SaveableObject : ISaveable {
    override fun save() {
        println("object saved")
    }
}