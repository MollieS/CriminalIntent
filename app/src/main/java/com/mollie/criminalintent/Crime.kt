package com.mollie.criminalintent

import java.util.*


class Crime(var id: UUID = UUID.randomUUID()) {
    lateinit var title: String
}