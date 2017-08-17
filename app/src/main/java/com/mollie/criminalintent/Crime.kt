package com.mollie.criminalintent

import java.util.*


class Crime {
    lateinit var title: String
    val id: UUID = UUID.randomUUID()
    val date: Date = Date()
    var solved: Boolean = false

    fun solve() {
        solved = true
    }
}