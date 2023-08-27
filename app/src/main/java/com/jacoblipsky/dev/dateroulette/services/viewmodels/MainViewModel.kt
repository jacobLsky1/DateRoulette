package com.jacoblipsky.dev.dateroulette.services.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacoblipsky.dev.dateroulette.models.Date
import com.jacoblipsky.dev.dateroulette.services.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.jetbrains.anko.doAsync
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val context: Context, private val repository: MainRepository
): ViewModel() {


    var currentMainFragment :Int? = null
    var query = ""



    private var _isSeraching :MutableLiveData<Boolean> = MutableLiveData(false)
    var isSeraching : LiveData<Boolean> = _isSeraching


    fun addDate(date: Date){
        doAsync {

        }
    }

    fun getRoomVideos(){
        doAsync {

        }
    }



    fun setSelectedVideo(video: Date){

    }

    fun resetVideos(text:String){

    }

    fun getLastVideos(){

    }

    fun getVideosFromWeb(query:String?, apiKey:String?){

    }

}