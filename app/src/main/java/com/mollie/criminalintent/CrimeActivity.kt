package com.mollie.criminalintent

import android.support.v4.app.FragmentActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class CrimeActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = CrimeFragment()
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}
