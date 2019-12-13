package com.challenge.taxi.rents

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornUrls
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(UnicornUrls.rentalsUrl)
class RentingController(val rentingService: RentingService) {

    @PostMapping
    fun rentUnicorn(@RequestBody rental: Rental ): ResponseEntity<Rental> {
        return rentingService.rent(rental)
    }
}
