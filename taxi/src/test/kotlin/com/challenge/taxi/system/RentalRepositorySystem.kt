package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentalRepository
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import java.util.*

class RentalRepositorySystem {
    companion object {
        val rentalIdMap: MutableMap<Long, Rental> = mutableMapOf()

        fun create(): RentalRepository {
            val rentalRepository: RentalRepository = Mockito.mock(RentalRepository::class.java)
            mockSave(rentalRepository)

            return rentalRepository
        }
        private fun mockSave(rentalRepository: RentalRepository) {
            Mockito.`when`(rentalRepository.save(any(Rental::class.java))).thenAnswer {
                val rental: Rental = it.getArgument(0)
                rentalIdMap.put(rental.rentalId, rental)

                rental
            }
        }

    }

}
