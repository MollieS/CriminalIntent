package com.mollie.criminalintent

import java.util.*


open class Crime(val id: UUID = UUID.randomUUID(),
                 val date: Date = Date()) {

    lateinit var title: String
    var solved: Boolean = false

    fun solve() {
        solved = true
    }
}