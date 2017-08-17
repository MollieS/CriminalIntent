package com.mollie.criminalintent

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec


class CrimeTest : StringSpec() {
    private val crime = Crime()

    init {
        "it has an id" {
            crime.id shouldNotBe null
        }

        "it can have a title" {
            crime.title = "title"

            crime.title shouldBe "title"
        }

        "it has a date" {
            crime.date shouldNotBe null
        }

        "it can be unsolved" {
            crime.solved shouldBe false
        }

        "it can be solved" {
            crime.solve()

            crime.solved shouldBe true
        }
    }
}

