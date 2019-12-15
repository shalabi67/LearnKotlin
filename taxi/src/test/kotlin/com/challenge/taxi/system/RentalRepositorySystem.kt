package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentalRepository
import com.challenge.taxi.unicorn.Unicorn
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import java.util.*

class RentalRepositorySystem {
    companion object {
        val rentalIdMap: MutableMap<Long, Rental> = mutableMapOf()
        var counter: Long = 0

        fun create(): RentalRepository {
            val rentalRepository: RentalRepository = Mockito.mock(RentalRepository::class.java)
            mockSave(rentalRepository)
            mockFindById(rentalRepository)

            return rentalRepository
        }
        private fun mockSave(rentalRepository: RentalRepository) {
            Mockito.`when`(rentalRepository.save(any(Rental::class.java))).thenAnswer {
                val rental: Rental = it.getArgument(0)
                counter++
                rental.rentalId = counter

                rentalIdMap.put(rental.rentalId, rental)

                rental
            }
        }

        private fun mockFindById(rentalRepository: RentalRepository) {
            Mockito.`when`(rentalRepository.findById(ArgumentMatchers.anyLong())).thenAnswer{ invocationOnMock ->
                val rentalId: Long = invocationOnMock.getArgument<Long>(0)
                val rental = rentalIdMap[rentalId]
                if(rental == null) {
                    Optional.empty<Unicorn>()
                } else {
                    Optional.of(rental)
                }

            }
        }

    }

}
