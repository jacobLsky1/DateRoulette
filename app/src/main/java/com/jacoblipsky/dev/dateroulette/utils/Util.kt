package com.jacoblipsky.dev.dateroulette.utils

import androidx.lifecycle.MutableLiveData

class Util {
    companion object{
        var hasInternet: MutableLiveData<Boolean> = MutableLiveData()
        var requestError:MutableLiveData<Int> = MutableLiveData(0)
        var isTracking : MutableLiveData<Boolean> = MutableLiveData(false)
        val apiKey = "AIzaSyB4EJgTquQGT-GPQkYP1dGQ5wLv3p4L8xE"
    }
}