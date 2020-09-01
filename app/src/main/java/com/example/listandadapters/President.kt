package com.example.listandadapters

import android.content.Context

class President (var name: String, var start: Int, var end: Int, var details: String, val url: String)
    :Comparable<President> {

    override fun compareTo(other: President): Int {
        return this.start.compareTo( other.start)
    }

    override fun toString(): String {
        return "$name $start $end"
    }

    companion object{
        fun initPresidentObjects (context: Context) : ArrayList<President> {
            val presidents = ArrayList<President>()

            val presidentInfo = context.resources.getStringArray(R.array.arrayOfPresidents)
            for (p in presidentInfo) {
                val info: List<String> = p.split( ',')
                val (name, start, end, details, url) = info

                presidents.add( President(name, start.toInt(), end.toInt(), details, url))
            }
            presidents.sort()
            return presidents
        }
    }
}