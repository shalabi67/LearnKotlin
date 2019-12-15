package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentalRepository
import com.challenge.taxi.rents.ReturnedRental
import com.challenge.taxi.rents.ReturnedRentalRepository
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import java.time.LocalDateTime
import java.util.*

class ReturnedRentalRepositorySystem {
    companion object {
        private val rentalIdMap: MutableMap<Long, ReturnedRental> = mutableMapOf()

        fun create(): ReturnedRentalRepository {
            val rentalRepository: ReturnedRentalRepository = Mockito.mock(ReturnedRentalRepository::class.java)
            mockSave(rentalRepository)

            return rentalRepository
        }
        private fun mockSave(rentalRepository: ReturnedRentalRepository) {
            Mockito.`when`(rentalRepository.save(any(ReturnedRental::class.java))).thenAnswer {
                val rental: ReturnedRental = it.getArgument(0)
                rentalIdMap.put(rental.rentalId, rental)

                rental
            }
        }

    }

}
