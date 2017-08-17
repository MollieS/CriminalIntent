package com.mollie.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText

class CrimeFragment : Fragment() {

    lateinit var titleField: EditText
    lateinit var crime: Crime
    lateinit var dateButton: Button
    lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflateFragment(inflater, container)
        setUpDateButton(view)
        setUpCheckBox(view)
        return view
    }

    private fun setUpDateButton(view: View) {
        dateButton = view.findViewById(R.id.crime_date)
        dateButton.text = crime.date.toString()
        dateButton.isEnabled = false
    }

    private fun setUpCheckBox(view: View) {
        solvedCheckBox = view.findViewById(R.id.crime_solved)
        solvedCheckBox.setOnCheckedChangeListener(SolveCheckListener(crime))
    }

    private fun inflateFragment(inflater: LayoutInflater, container: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title)
        titleField.addTextChangedListener(TitleTextWatcher(crime))
        return view
    }
}

class SolveCheckListener(private val crime: Crime) : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(button: CompoundButton?, checked: Boolean) {
        crime.solved = checked
    }
}
