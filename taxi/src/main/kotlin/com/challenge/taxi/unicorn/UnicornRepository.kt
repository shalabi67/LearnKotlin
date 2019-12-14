package com.challenge.taxi.unicorn

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UnicornRepository: JpaRepository<Unicorn, Long> {
    fun findUnicornByUnicornName(unicornName: String): Unicorn
}
