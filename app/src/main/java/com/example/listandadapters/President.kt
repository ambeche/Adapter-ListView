package com.example.listandadapters

import android.content.Context

class President (var name: String, var start: Int, var end: Int, var details: String) :
    Comparable<President> {
    override fun compareTo(other: President): Int {
        return this.start.compareTo(this.end)
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
                val (name, start, end, details) = info

                presidents.add( President(name, start.toInt(), end.toInt(), details ))
            }
            presidents.sort()
            return presidents
        }
    }
}