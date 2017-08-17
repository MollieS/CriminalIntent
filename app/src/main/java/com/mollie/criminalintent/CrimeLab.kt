package com.mollie.criminalintent

import java.util.*


object CrimeLab {

    private val listOfCrimes: MutableList<Crime> = populate()

    fun getCrimes(): List<Crime> = listOfCrimes

    fun addCrime(crime: Crime) = listOfCrimes.add(crime)

    fun getCrime(id: UUID): Crime? = listOfCrimes.find { it -> it.id == id }

    private fun populate(): MutableList<Crime> {
        val listOfCrimes = mutableListOf<Crime>()
        for (i in 1..100) {
            val crime = Crime()
            if (i.rem(2) == 0) {
                crime.solve()
            }
            listOfCrimes.add(crime)
        }
        return listOfCrimes
    }

}