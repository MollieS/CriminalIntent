package com.mollie.criminalintent

import android.text.Editable
import android.text.TextWatcher


class TitleTextWatcher(val crime: Crime) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun onTextChanged(title: CharSequence?, start: Int, before: Int, count: Int) {
        crime.title = title.toString()
    }
}