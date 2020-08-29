package com.example.listandadapters

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val presidents = GlobalPresident.presidents
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = PresidentAdapter(this, presidents)

        listView.onItemClickListener = OnItemClickListener()
    }

    private inner class OnItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, v: View?, pos: Int, rowId: Long) {
            val president = presidents[pos]
            tvName.text = president.name
            tvStartDate.text = "${president.start}"
            tvEndDate.text = "${president.end}"
            tvDetails.text = president.details
            linearLayout2.setBackgroundColor(getColor(R.color.colorPrimaryDark))
        }
    }
}