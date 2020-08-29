package com.example.listandadapters

class President (var name: String, var start: Int, var end: Int, var details: String) :
    Comparable<President> {
    override fun compareTo(other: President): Int {
        return this.start.compareTo(this.end)
    }

    override fun toString(): String {
        return "$name $start $end"
    }
}