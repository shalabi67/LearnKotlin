package com.challenge.taxi.unicorn

import javax.persistence.*

@Entity
data class Unicorn(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var unicornId: Long = -1,
    var unicornName: String = "",

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    var isRented: Boolean = false,

    @Column(columnDefinition="tinyint default 15")
    var restDuration: Short = 15
) {}
