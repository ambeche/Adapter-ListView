package com.example.listandadapters

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.content.Intent.EXTRA_TITLE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var presidents: ArrayList<President>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        presidents = President.initPresidentObjects(this)
        Log.d("presidents" , presidents.toString())

        listView.adapter = PresidentAdapter(this, presidents)
        listView.onItemClickListener = OnItemClickListener()
        listView.onItemLongClickListener = OnItemLongClickListener()
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