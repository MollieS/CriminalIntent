package com.mollie.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment

class CrimeFragment : Fragment() {

    lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }
}