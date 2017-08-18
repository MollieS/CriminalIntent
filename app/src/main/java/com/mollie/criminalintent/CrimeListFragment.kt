package com.mollie.criminalintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast


class CrimeListFragment : Fragment() {

    private lateinit var crimeRecyclerView: RecyclerView
    private lateinit var crimeAdapter: CrimeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_crime_list, container, false)
        crimeRecyclerView = view.findViewById(R.id.crime_recycler)
        crimeRecyclerView.layoutManager = LinearLayoutManager(activity)

        updateUI()

        return view
    }

    private fun updateUI() {
        val crimes = CrimeLab.getCrimes()
        crimeAdapter = CrimeAdapter(crimes, activity)
        crimeRecyclerView.adapter = crimeAdapter
    }

    private class CrimeHolder(itemView: View, val activity: Activity) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val titleView: TextView = itemView.findViewById(R.id.list_item_crime_title_text_view)
        val dateTextView: TextView = itemView.findViewById(R.id.list_item_crime_date_text_view)
        val solvedCheckbox: CheckBox = itemView.findViewById(R.id.list_item_crime_solved_checkbox)
        lateinit var crime: Crime

        init {
            itemView.setOnClickListener(this)
        }

        fun bindCrime(crime: Crime) {
            this.crime = crime
            titleView.text = crime.title
            dateTextView.text = crime.date.toString()
            solvedCheckbox.isChecked = crime.solved
        }

        override fun onClick(view: View?) {
            val intent = Intent(activity, CrimeActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private class CrimeAdapter(val crimes: List<Crime>, val activity: Activity) : RecyclerView.Adapter<CrimeHolder>() {

        override fun onBindViewHolder(holder: CrimeHolder?, position: Int) {
            val crime: Crime = crimes[position]
            holder?.bindCrime(crime)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CrimeHolder {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            val view: View = inflater.inflate(R.layout.list_item_crime, parent, false)
            return CrimeHolder(view, activity)
        }

        override fun getItemCount(): Int = crimes.count()
    }
}