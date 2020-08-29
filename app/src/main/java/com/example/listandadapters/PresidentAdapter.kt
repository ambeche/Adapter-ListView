package com.example.listandadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PresidentAdapter(context: Context, private  val presidents: ArrayList<President>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
       return presidents.size
    }

    override fun getItem(pos: Int): Any {
        return presidents[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        val rowView = if (view === null)
            inflater.inflate(R.layout.president_item_list, parent,false)
        else view

        val president = presidents[pos]

        val tvName = rowView.findViewById(R.id.tvNameCell) as TextView // findViewById<TextView>
        tvName.text = president.name

        val tvStart = rowView.findViewById(R.id.tvStartDateCell) as TextView
        tvStart.text = "${president.start}"

        val tvEnd = rowView.findViewById(R.id.tvEndDateCell) as TextView
        tvEnd.text = "${president.end}"

        return rowView
    }

}