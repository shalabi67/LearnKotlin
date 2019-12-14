package com.challenge.taxi.system

import com.challenge.taxi.customer.Customer
import com.challenge.taxi.rents.Rental
import com.challenge.taxi.unicorn.Unicorn

class RentalData {
    companion object {
        fun createValidRental(): Rental {
            return  Rental(unicorn = Unicorn(), customer = Customer(1))
        }
    }
}
