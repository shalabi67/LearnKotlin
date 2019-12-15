package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentingController
import com.challenge.taxi.rents.RentingService
import com.challenge.taxi.rents.ReturnedRental
import com.challenge.taxi.unicorn.UnicornRepository
import org.springframework.http.ResponseEntity

class RentingSystem {
    companion object {

        fun create(): RentingSystem {
            val rentingSystem =  RentingSystem()
            rentingSystem.unicornRepository = UnicornRepositorySystem.create().unicornRepository;
            val rentingService = RentingService(RentalRepositorySystem.create(),
                    rentingSystem.unicornRepository,
                    ReturnedRentalRepositorySystem.create(),
                    SchedulerSystem.create(rentingSystem.unicornRepository).schedulerService)

            rentingSystem.rentingController = RentingController(rentingService)

            return rentingSystem
        }
    }

    lateinit var rentingController: RentingController
    lateinit var unicornRepository: UnicornRepository

    fun rentUnicorn(rental: Rental) : ResponseEntity<Rental> {
        return rentingController.rentUnicorn(rental)
    }

    fun returnUnicorn(rentalId: Long): ResponseEntity<ReturnedRental> {
        return rentingController.returnUnicorn(rentalId)
    }
}
