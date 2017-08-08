package com.mollie.criminalintent

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class TitleTextWatcherTest : StringSpec() {
    init {
        "it updates the crime title when text changed" {
            val crime = Crime()
            val textWatcher = TitleTextWatcher(crime)

            textWatcher.onTextChanged("title", 0, 0, 0)

            crime.title shouldBe "title"
        }
    }
}