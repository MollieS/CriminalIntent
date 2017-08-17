package com.mollie.criminalintent

import java.util.*


class Crime(val id: UUID = UUID.randomUUID(), val date: Date = Date()) {
    lateinit var title: String
}