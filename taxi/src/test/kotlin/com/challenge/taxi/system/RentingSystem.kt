package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentingController
import com.challenge.taxi.rents.RentingService
import com.challenge.taxi.rents.ReturnedRental
import org.springframework.http.ResponseEntity

class RentingSystem {
    companion object {

        fun create(): RentingSystem {
            val rentingSystem =  RentingSystem()
            val unicornRepository = UnicornRepositorySystem.create().unicornRepository;
            val rentingService = RentingService(RentalRepositorySystem.create(),
                    unicornRepository,
                    ReturnedRentalRepositorySystem.create(),
                    SchedulerSystem.create(unicornRepository).schedulerService)

            rentingSystem.rentingController = RentingController(rentingService)

            return rentingSystem
        }
    }

    lateinit var rentingController: RentingController

    fun rentUnicorn(rental: Rental) : ResponseEntity<Rental> {
        return rentingController.rentUnicorn(rental)
    }

    fun returnUnicorn(rentalId: Long): ResponseEntity<ReturnedRental> {
        return rentingController.returnUnicorn(rentalId)
    }
}
