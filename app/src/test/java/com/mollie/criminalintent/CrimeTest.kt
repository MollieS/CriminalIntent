package com.mollie.criminalintent

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec


class CrimeTest : StringSpec() {
    init {
        "it has an id" {
            val crime = Crime()

            crime.id shouldNotBe null
        }

        "it can have a title" {
            val crime = Crime()

            crime.title = "title"

            crime.title shouldBe "title"
        }
    }
}

