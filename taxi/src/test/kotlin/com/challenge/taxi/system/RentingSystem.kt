package com.challenge.taxi.system

import com.challenge.taxi.rents.Rental
import com.challenge.taxi.rents.RentingController
import com.challenge.taxi.rents.RentingService
import org.springframework.http.ResponseEntity

class RentingSystem {
    companion object {

        fun create(): RentingSystem {
            val rentingSystem =  RentingSystem()
            val rentingService = RentingService(RentalRepositorySystem.create(),
                    UnicornRepositorySystem.create().unicornRepository)

            rentingSystem.rentingController = RentingController(rentingService)

            return rentingSystem
        }


    }

    lateinit var rentingController: RentingController

    fun rentUnicorn(rental: Rental) : ResponseEntity<Rental> {
        return rentingController.rentUnicorn(rental)
    }
}
