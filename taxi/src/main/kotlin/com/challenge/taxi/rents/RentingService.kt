package com.challenge.taxi.rents

import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class RentingService(val rentalRepository: RentalRepository,
                     val unicornRepository: UnicornRepository,
                     val returnedRentalRepository: ReturnedRentalRepository,
                     val schedulerService: SchedulerService) {


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

        return ResponseEntity(addRental(rental), HttpStatus.CREATED)
    }

    fun returnUnicorn(rentalId: Long): ResponseEntity<ReturnedRental> {
        val rentalOptional = rentalRepository.findById(rentalId)
        if(!rentalOptional.isPresent) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        return returnUnicorn(rentalOptional.get())
    }

    @Transactional
    protected fun returnUnicorn(rental: Rental): ResponseEntity<ReturnedRental> {
        val returnedRental = ReturnedRental(rental.rentalId, rental.unicorn, rental.customer, rental.rentingDateTime)

        rentalRepository.delete(rental)

        val result = ResponseEntity.ok(returnedRentalRepository.save(returnedRental))

        schedulerService.enableUnicornForRenting(returnedRental.unicorn)

        return result;
    }

    private fun isInvalidUnicorn(unicorn: Unicorn): Boolean {
        return  unicorn.unicornId<=0 ||
                unicorn.unicornName.trim().isEmpty() ||
                unicorn.isRented
    }

    @Transactional
    protected fun addRental(rental: Rental) : Rental {
        return rentalRepository.save(rental);
    }
}
