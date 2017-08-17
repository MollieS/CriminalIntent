package com.mollie.criminalIntent

import android.content.*
import android.widget.EditText
import io.kotlintest.matchers.shouldNotBe
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment
import android.text.TextWatcher
import com.mollie.criminalintent.BuildConfig
import com.mollie.criminalintent.CrimeFragment
import io.kotlintest.matchers.shouldBe
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class CrimeFragmentTest {

    @Test
    fun createsACrimeOnCreate() {
        val crimeFragment = CrimeFragment()

        startFragment(crimeFragment)

        crimeFragment.crime shouldNotBe null
    }

    @Test
    fun getsTitleFieldFromView() {
        val crimeFragment = CrimeFragment()

        startFragment(crimeFragment)

        crimeFragment.titleField shouldNotBe null
    }

    @Test
    fun setsTextChangedListenerOnTitleField() {
        val editTextSpy = EditTextSpy(RuntimeEnvironment.application)
        val crimeFragment = CrimeFragment(editTextSpy)

        startFragment(crimeFragment)

        editTextSpy.textChangedListenerIsSet shouldBe true
    }
}

class EditTextSpy(context: Context) : EditText(context) {

    var textChangedListenerIsSet = false

    override fun addTextChangedListener(watcher: TextWatcher?) {
        textChangedListenerIsSet = true
    }

}
