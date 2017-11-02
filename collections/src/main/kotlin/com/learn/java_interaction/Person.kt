package com.learn.java

import com.learn.java_interaction.java.Meeting
import com.learn.java_interaction.java.Organizer

class Person : Organizer {
    override fun processMeetings(meetings: List<Meeting>) {

    }
/*
all of the folloing is correct
    override fun processMeetings(meetings: MutableList<Meeting>?) {

    }

    override fun processMeetings(meetings: MutableList<Meeting?>?) {

    }

    override fun processMeetings(meetings: MutableList<Meeting?>) {

    }

    override fun processMeetings(meetings: MutableList<Meeting>) {

    }

    override fun processMeetings(meetings: List<Meeting?>) {

    }

    override fun processMeetings(meetings: List<Meeting>?) {

    }
 */
}