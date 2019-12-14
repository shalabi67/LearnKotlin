package com.challenge.taxi.health

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HealthController {

    @GetMapping("/healtz")
    fun getHealth(): String {
        return "forward:/health";
    }
}
