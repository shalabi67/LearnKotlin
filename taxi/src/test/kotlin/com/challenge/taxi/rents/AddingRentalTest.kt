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
class AddingRentalTest {
    lateinit var rentingSystem: RentingSystem
    lateinit var rental: Rental

    @BeforeEach
    fun setup() {
        rentingSystem = RentingSystem.create()
        rental = RentalData.createValidRental()
    }

    @Test
    fun testAddingValidRental() {
        rental.unicorn = Unicorn(1, "Pinky Pie")

        val response = rentingSystem.rentUnicorn(rental)

        Assertions.assertEquals(HttpStatus.CREATED, response.statusCode)
        val newRental = response.body
        Assertions.assertNotNull(newRental)
        Assertions.assertEquals(true, newRental?.unicorn?.isRented)
    }

    @Test
    fun testAddingInvalidUnicorn() {

        val response = rentingSystem.rentUnicorn(rental)

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
    }
}
