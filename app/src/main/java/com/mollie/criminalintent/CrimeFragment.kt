package com.mollie.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class CrimeFragment(var titleField: EditText? = null) : Fragment() {

    lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = null
        if (inflater is LayoutInflater) {
            view = inflater.inflate(R.layout.fragment_crime, container, false)
            titleField = view.findViewById(R.id.crime_title)
        }
        return view
    }
}