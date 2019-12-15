package com.challenge.taxi.rents

import com.challenge.taxi.system.RentalData
import com.challenge.taxi.system.RentingSystem
import com.challenge.taxi.unicorn.UnicornUrls.rental
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness

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

    }
}
