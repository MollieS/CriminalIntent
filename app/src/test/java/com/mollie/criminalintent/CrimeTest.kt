package com.mollie.criminalintent

import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec


class CrimeTest : StringSpec() {
    init {
        "it has an id" {
            var crime: Crime = Crime()

            crime.id shouldNotBe null
        }
    }
}

