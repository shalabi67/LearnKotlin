package com.challenge.taxi.rents

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornRepository
import org.springframework.stereotype.Service
import java.util.concurrent.Executors

@Service
class SchedulerService(val unicornRepository: UnicornRepository) {
    private val scheduledExecutor = Executors.newCachedThreadPool()

    fun enableUnicornForRenting(unicorn: Unicorn) {
        scheduledExecutor.submit{
            try {
                sleep(unicorn.restDuration*60*1000L)
                unicorn.isRented = false;
                unicornRepository.save(unicorn)
            } catch(e: Exception) {
                //TODO: now we have a unicorn that is available but shown as not available.
            }
        }
    }

    fun sleep(milliseconds: Long) {
        Thread.sleep(milliseconds); //could use TimeUnit
    }
}
