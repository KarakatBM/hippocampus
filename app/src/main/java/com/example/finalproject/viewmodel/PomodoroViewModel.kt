package com.example.finalproject.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PomodoroViewModel: ViewModel() {

    private val pomodorosArray = arrayOf(1,3,4)
    private val restArray = arrayOf(5,10,15)

    private var  initialMins = pomodorosArray[0]
    private var  initialSeconds = 5

    private var i = 0
    private var j = 0

    private var  _mins = MutableLiveData<Int>(initialMins)
    val mins:LiveData<Int>
        get() = _mins
    private var  _seconds = MutableLiveData<Int>(initialSeconds)
    val seconds:LiveData<Int>
        get() = _seconds

    private var  restMins = restArray[i]

    private var  _status = MutableLiveData<String>("wait")
    val status: LiveData<String>
        get() = _status

    private var  _mode = MutableLiveData<String>("focus")
    val mode: LiveData<String>
        get() = _mode

    fun setStartStatus(){
        _status.value = "start"
    }
    fun setStopStatus(){
        _status.value = "wait"
    }

    fun setModeFocus(){
        _mode.value = "focus"
    }
    fun setModeRest(){
        _mode.value = "rest"
    }

    private fun decreaseSeconds(){
        _seconds.value = _seconds.value?.minus(1)
    }
    private fun decreaseMins(){
        _mins.value = _mins.value?.minus(1)
    }
    fun decreaseTimer(){
        if(_seconds.value != 0){
            this.decreaseSeconds()
        } else {
            _seconds.value = 59
            this.decreaseMins()
        }
    }
    fun resetFocusTimer(){
        _mins.value = initialMins
        _seconds.value = initialSeconds
    }
    fun resetRestTimer(){
        _mins.value = restMins
        _seconds.value = initialSeconds
    }
    fun handleTimerLength(){
        if(_mode.value == "focus"){
            if (i == pomodorosArray.size-1){
                i = 0
            }
            initialMins = pomodorosArray[++i]
            restMins = restArray[i]

            _mins.value = initialMins
            _seconds.value = initialSeconds

        }
        else if(_status.value == "rest"){
            if (j == pomodorosArray.size-1){
                j = 0
            }
            restMins = restArray[j++]

            _mins.value = restMins
            _seconds.value = initialSeconds
        }
    }



}