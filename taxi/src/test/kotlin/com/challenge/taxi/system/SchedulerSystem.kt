package com.challenge.taxi.system

import com.challenge.taxi.rents.SchedulerService
import com.challenge.taxi.unicorn.UnicornRepository
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito

class SchedulerSystem {
    companion object {

        fun create(unicornRepository: UnicornRepository): SchedulerSystem {
            val schedulerSystem =  SchedulerSystem()
            val schedulerService = SchedulerService(unicornRepository)
            schedulerSystem.schedulerService = Mockito.spy(schedulerService)

            schedulerSystem.mockThreadSleep()

            return schedulerSystem
        }


    }

    lateinit var schedulerService: SchedulerService

    private fun mockThreadSleep() {
        Mockito.doAnswer{}.`when`(schedulerService).sleep(anyLong())
    }
}
