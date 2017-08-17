package com.mollie.criminalintent

import android.support.v4.app.Fragment

class CrimeActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = CrimeFragment()
}
