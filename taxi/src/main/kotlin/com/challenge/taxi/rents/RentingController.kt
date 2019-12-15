package com.challenge.taxi.rents

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornUrls
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(UnicornUrls.rentalsUrl)
class RentingController(val rentingService: RentingService) {

    @PostMapping
    fun rentUnicorn(@RequestBody rental: Rental ): ResponseEntity<Rental> {
        return rentingService.rent(rental)
    }

    @DeleteMapping(UnicornUrls.rental)
    fun returnUnicorn(@PathVariable("rentalId") rentalId: Long): ResponseEntity<ReturnedRental> {
        return rentingService.returnUnicorn(rentalId)
    }
}
