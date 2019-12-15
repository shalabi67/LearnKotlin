package com.challenge.taxi.rents

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReturnedRentalRepository: JpaRepository<ReturnedRental, Long> {
}
