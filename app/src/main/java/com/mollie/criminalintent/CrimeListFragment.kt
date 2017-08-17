package com.mollie.criminalintent

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


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

    private class CrimeHolder(val titleView: TextView) : RecyclerView.ViewHolder(titleView)

    private class CrimeAdapter(val crimes: List<Crime>, val activity: Activity) : RecyclerView.Adapter<CrimeHolder>() {

        override fun onBindViewHolder(holder: CrimeHolder?, position: Int) {
            val crime: Crime = crimes[position]
            holder?.titleView?.text = crime.date.toString()
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CrimeHolder {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            val view: View = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            return CrimeHolder(view as TextView)
        }

        override fun getItemCount(): Int = crimes.count()
    }
}