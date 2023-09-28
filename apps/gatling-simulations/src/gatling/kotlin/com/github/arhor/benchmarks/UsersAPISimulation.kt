package com.github.arhor.benchmarks

import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import java.time.Duration

class UsersAPISimulation : Simulation() {

    private val httpProtocol = http
        .baseUrl("http://localhost:5000")
        .acceptHeader("application/json")

    private val scenario = scenario("TestSimulation")
        .exec(http("Get all users").get("/users"))

    init {
        this.setUp(scenario.injectOpen(constantUsersPerSec(50.0).during(Duration.ofSeconds(15))))
            .protocols(httpProtocol)
    }
}


