package com.challenge.taxi.system

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornRepository
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito
import java.util.*

class UnicornRepositorySystem {
    companion object {

        fun create(): UnicornRepositorySystem {
            val unicornRepositorySystem = UnicornRepositorySystem()
            unicornRepositorySystem.initializeUnicornMap()
            mockFindById(unicornRepositorySystem)


            return unicornRepositorySystem;
        }

        private fun mockFindById(unicornRepositorySystem: UnicornRepositorySystem) {
            Mockito.`when`(unicornRepositorySystem.unicornRepository.findById(anyLong())).thenAnswer{ invocationOnMock ->
                val argument: Long = invocationOnMock.getArgument(0)
                val unicorn = unicornRepositorySystem.unicornIdMap[argument]
                if(unicorn == null) {
                    Optional.empty<Unicorn>()
                } else {
                    Optional.of(unicorn)
                }

            }
        }

    }



    val unicornRepository: UnicornRepository = Mockito.mock(UnicornRepository::class.java)
    private val unicornIdMap: MutableMap<Long, Unicorn> = mutableMapOf()
    private val unicornNameMap: MutableMap<String, Unicorn> = mutableMapOf()



    private fun initializeUnicornMap() {
        addToMap(createUnicorn(1, "Pinky Pie"))
        addToMap(createUnicorn(2, "Rainbow Dash"))
        addToMap(createUnicorn(3, "Fluttershy"))
        addToMap(createUnicorn(4, "Twilight Sparkle", 30))
    }

    private fun addToMap(unicorn: Unicorn) {
        unicornIdMap.put(unicorn.unicornId, unicorn)
        unicornNameMap.put(unicorn.unicornName, unicorn)
    }

    private fun createUnicorn(unicornId: Long, unicornName: String, restDuration: Short=15): Unicorn {
        val unicorn = Unicorn();
        unicorn.unicornId = unicornId
        unicorn.unicornName = unicornName
        unicorn.restDuration = restDuration

        return unicorn
    }
}
