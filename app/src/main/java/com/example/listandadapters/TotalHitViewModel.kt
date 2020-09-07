package com.example.listandadapters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kotlinx.coroutines.Dispatchers

class TotalHitViewModel : ViewModel() {
    private val repository : WikiRepository = WikiRepository()
    val query = MutableLiveData<String>()

    fun queryName(name: String) { query . value = name }
    val hitCount = query.switchMap {name ->
        liveData (Dispatchers.IO ) { emit( repository.getTotalHits( name )) }
    }
}

class WikiRepository() {
    private val call = TotalHitApi.service
    suspend fun getTotalHits(name: String) = call.presidentName(name)
}
