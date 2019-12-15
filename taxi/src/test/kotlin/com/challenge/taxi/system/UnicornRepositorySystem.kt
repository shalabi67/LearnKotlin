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
            unicornRepositorySystem.mockFindById()

            return unicornRepositorySystem;
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

    private fun mockFindById() {
        Mockito.`when`(unicornRepository.findById(anyLong())).thenAnswer{ invocationOnMock ->
            val argument: Long = invocationOnMock.getArgument<Long>(0)
            val unicorn = unicornIdMap[argument]
            if(unicorn == null) {
                Optional.empty<Unicorn>()
            } else {
                Optional.of(unicorn)
            }

        }
    }

    private fun mockSave() {
        Mockito.`when`(unicornRepository.save(any(Unicorn::class.java))).thenAnswer {
            val unicorn: Unicorn = it.getArgument<Unicorn>(0)
            if(unicornIdMap.containsKey(unicorn.unicornId)) {
                unicornIdMap[unicorn.unicornId] = unicorn
                Optional.of(unicorn)
            } else {
                Optional.empty<Unicorn>()
            }
        }
    }
}
