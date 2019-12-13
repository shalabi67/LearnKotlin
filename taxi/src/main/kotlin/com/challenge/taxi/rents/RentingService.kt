package com.challenge.taxi.rents

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RentingService(val rentalRepository: RentalRepository, val unicornRepository: UnicornRepository) {

    fun rent(rental: Rental): ResponseEntity<Rental> {
        if(rental.customer.customerId<0 || rental.unicorn.unicornId<=0 ) {
            return ResponseEntity(rental, HttpStatus.BAD_REQUEST)
        }

        val unicornOptional = unicornRepository.findById(rental.unicorn.unicornId);
        if(!unicornOptional.isPresent) {
            return ResponseEntity(rental, HttpStatus.NOT_FOUND)
        }

        rental.unicorn = unicornOptional.get()
        if(isInvalidUnicorn(rental.unicorn)) {
            return ResponseEntity(rental, HttpStatus.GONE)
        }

        rental.unicorn.isRented = true
        rental.rentingDateTime = LocalDateTime.now()

        return ResponseEntity.ok(rentalRepository.save(rental))
    }

    private fun isInvalidUnicorn(unicorn: Unicorn): Boolean {
        return  unicorn.unicornId<=0 ||
                unicorn.unicornName.trim().isEmpty() ||
                unicorn.isRented
    }
}
