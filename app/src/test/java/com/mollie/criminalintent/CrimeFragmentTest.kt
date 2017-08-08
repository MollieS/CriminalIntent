package com.mollie.criminalintent

import io.kotlintest.matchers.shouldNotBe
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment


@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class CrimeFragmentTest {

    @Test
    fun createsACrimeOnCreate() {
        val crimeFragment: CrimeFragment = CrimeFragment()

        startFragment(crimeFragment)

        crimeFragment.crime shouldNotBe null
    }
}
