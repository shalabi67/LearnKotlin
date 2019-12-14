package com.challenge.taxi.system

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornRepository
import org.mockito.Mockito

class UnicornRepositorySystem {
    companion object {
        fun create(): UnicornRepositorySystem {
            val unicornRepositorySystem = UnicornRepositorySystem()
            unicornRepositorySystem.unicornRepository

            return unicornRepositorySystem;
        }

        private fun mockFindById(unicornRepositorySystem: UnicornRepositorySystem) {
           // Mockito.`when`(unicornRepositorySystem.unicornRepository).thenReturn()
        }

        private fun createUnicornMap(): Map<Long, Unicorn> {
            return mapOf(
                    1L to createUnicorn(1, "Pinky Pie", 15),
                    2L to createUnicorn(1, "Pinky Pie", 15),
                    3L to createUnicorn(1, "Pinky Pie", 15),
                    4L to createUnicorn(1, "Pinky Pie", 15)
            )

        }
        private fun createUnicorn(unicornId: Long, unicornName: String, restDuration: Short=15): Unicorn {
            val unicorn = Unicorn();
            unicorn.unicornId = unicornId
            unicorn.unicornName = unicornName
            unicorn.restDuration = restDuration

            return unicorn
        }
    }


    private var unicornRepository: UnicornRepository = Mockito.mock(UnicornRepository::class.java)

}
