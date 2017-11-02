package com.learn.nullable_types.java_interaction

import com.learn.nullable_types.java_interaction.java.IAddress

class HomeAddress : IAddress{
    override fun getStreetAddress(): String {
        return ""
    }
}

class WorkAddress : IAddress{
    override fun getStreetAddress(): String? {
        return null
    }
}