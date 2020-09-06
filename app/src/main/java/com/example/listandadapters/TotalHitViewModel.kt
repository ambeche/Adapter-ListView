package com.example.listandadapters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kotlinx.coroutines.Dispatchers

class TotalHitViewModel : ViewModel() {
    val repository : WikiRepository = WikiRepository()
    private val query = MutableLiveData<String>()
    fun queryName(name: String) { query . value = name }
    val hitCount = query . switchMap {
        liveData (Dispatchers.IO ) { emit( repository.getTotalHits( it )) }
    }
}

class WikiRepository() {
    private val call = TotalHitApi.service
    suspend fun getTotalHits(name: String) = call.presidentName(name)
}
