package com.challenge.taxi.rents

import com.challenge.taxi.customer.Customer
import com.challenge.taxi.unicorn.Unicorn
import com.challenge.taxi.unicorn.UnicornUrls
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


//@ExtendWith(MockitoExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AddingRentalIT(@Autowired val mockMvc: MockMvc) {

    @Test
    fun testAddingValidRental() {
        val rental = createRental()
        rental.unicorn = Unicorn(1, "Pinky Pie")

        mockMvc.perform(post(UnicornUrls.rentalsUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(rentalToString(rental))
        )
        .andExpect(status().isCreated)
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("\$.unicorn.isRented").value(true))
    }

    private fun createRental(): Rental {
        return  Rental(unicorn = Unicorn(), customer = Customer(1))
    }

    private fun rentalToString(rental: Rental): String {
        val mapper = jacksonObjectMapper()
        mapper.registerModule(JavaTimeModule())
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

        return mapper.writeValueAsString(rental)
    }
}
