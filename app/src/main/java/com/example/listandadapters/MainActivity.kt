package com.example.listandadapters

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.content.Intent.EXTRA_TITLE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var presidents: ArrayList<President>
    lateinit var totalHitViewModel: TotalHitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        presidents = President.initPresidentObjects(this)
        Log.d("presidents" , presidents.toString())

        totalHitViewModel = ViewModelProvider(this).get(TotalHitViewModel::class.java)

        listView.adapter = PresidentAdapter(this, presidents)
        listView.onItemLongClickListener = OnItemLongClickListener()

        listView.setOnItemClickListener{_, _, pos, _, ->
            displayDetails(pos)
            Log.d("hits", totalHitViewModel.query.value.toString())
            totalHitViewModel.hitCount.observe(this, Observer {data ->
                val hits = data.query.searchInfo.totalHits.toString()
                tvHits.text = hits
                Log.d("hits", hits)
            })
        }
    }

    private fun displayDetails (pos: Int) {
        val president = presidents[pos]
        tvName.text = president.name
        tvStartDate.text = "${president.start}"
        tvEndDate.text = "${president.end}"
        tvDetails.text = president.details
        linearLayout2.setBackgroundColor(getColor(R.color.colorPrimaryDark))

        totalHitViewModel.queryName(president.name)
    }

    private inner class OnItemLongClickListener : AdapterView.OnItemLongClickListener {
        override fun onItemLongClick(parent: AdapterView<*>?, v: View?, pos: Int, id: Long)
                : Boolean {
            val intent = Intent(this@MainActivity, PresidentWebView::class.java)
            intent.putExtra(EXTRA_TEXT, presidents[pos].url)
            intent.putExtra(EXTRA_TITLE, presidents[pos].name)

            startActivity(intent)
            return true
        }
    }
}