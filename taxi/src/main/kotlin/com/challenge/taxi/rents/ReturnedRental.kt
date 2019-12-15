package com.challenge.taxi.rents

import com.challenge.taxi.customer.Customer
import com.challenge.taxi.unicorn.Unicorn
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ReturnedRental(
    @Id
    var rentalId: Long = -1,

    @ManyToOne
    @JoinColumn(name="unicorn_id", nullable=false)
    var unicorn: Unicorn,

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    var customer: Customer,

    var rentingDateTime: LocalDateTime = LocalDateTime.now(),
    var returnDateTime: LocalDateTime = LocalDateTime.now()
) {}
