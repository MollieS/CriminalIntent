package com.mollie.criminalintent

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.*


class CrimeLabTest : StringSpec() {
    init {
        "it has 100 crimes" {
            val crimes = CrimeLab.getCrimes()

            crimes.count() shouldBe 100
        }

        "it can find a crime by id" {
            val id = UUID.randomUUID()
            val crime = Crime(id)
            CrimeLab.addCrime(crime)
            CrimeLab.getCrime(id) shouldBe crime
        }

    }
}
