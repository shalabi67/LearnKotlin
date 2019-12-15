package com.challenge.taxi.rents

import com.challenge.taxi.system.RentalData
import com.challenge.taxi.system.RentingSystem
import com.challenge.taxi.unicorn.Unicorn
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ReturnedRentalTest {
    lateinit var rentingSystem: RentingSystem
    lateinit var rental: Rental

    @BeforeEach
    fun setup() {
        rentingSystem = RentingSystem.create()
        rental = RentalData.createValidRental()
    }

    @Test
    fun testReturnedRental() {
        rental.unicorn = Unicorn(1, "Pinky Pie")
        val response = rentingSystem.rentUnicorn(rental)
        Assertions.assertEquals(HttpStatus.CREATED, response.statusCode)
        val newRental = response.body

        if(newRental != null) {
            val responseEntity = rentingSystem.returnUnicorn(newRental.rentalId)
            Assertions.assertEquals(HttpStatus.OK, responseEntity.statusCode)

            Thread.sleep(20)  //just give a chance to the scheduler to execute

            val returnedRental = responseEntity.body
            if(returnedRental != null) {
                Assertions.assertNotNull(returnedRental)
                val unicornOptional = rentingSystem.unicornRepository.findById(returnedRental.unicorn.unicornId)
                Assertions.assertEquals(false, unicornOptional.get().isRented)
            } else {
                Assertions.fail<Long>()
            }

        } else {
            Assertions.fail<Long>()
        }
    }

    @Test
    fun testReturnNonExitingRental() {
        val responseEntity = rentingSystem.returnUnicorn(6)

        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.statusCode)
    }
}
