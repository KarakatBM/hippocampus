package com.example.finalproject



import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.example.finalproject.databinding.FragmentPomodoroBinding
import android.os.Handler
import android.service.autofill.Validators.not

class PomodoroFragment : Fragment() {
      private var handler = Handler(Looper.getMainLooper())
      private lateinit var runnable: Runnable
    val pomodorosArray = arrayOf(0,3,4)
    val restArray = arrayOf(5,10,15)

    var initialMins = pomodorosArray[0]
    private var i = 0
    private var j = 0
    var initialSeconds = 5
    var mins = initialMins
    var seconds = initialSeconds
    var status = "wait"
    var restMins = restArray[i]
    var mode = "focus"

    private var binding: FragmentPomodoroBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentPomodoroBinding.inflate(inflater, container, false)
        //initial timer 25 mins
        binding!!.startButton.setOnClickListener{
            if(status == "wait"){
                onTimerStarted()
            }
            else {
                onTimerStopped()
            }

        }



        binding!!.timer.setOnClickListener{

            handleTimerLength()
        }


        binding!!.skipButton.setOnClickListener{
            handleSkipButton()
        }




        return binding!!.root
    }

    private fun handleSkipButton() {
        switchFocusMode()
    }

    override fun onStart() {
        super.onStart()
        updateTimer(mins,seconds)
    }

    private fun handleTimerLength() {
        if(mode == "focus"){
            if (i == pomodorosArray.size-1){
            i = 0
        }
            initialMins = pomodorosArray[++i]
            restMins = restArray[i]

            mins = initialMins
            seconds = initialSeconds

        }
        else if(status == "rest"){
            if (j == pomodorosArray.size-1){
                j = 0
            }
            restMins = restArray[j++]
            seconds = initialSeconds
        }
        updateTimer(mins, seconds)
        


    }

    private fun onTimerStarted() {
        status = "started"
        binding!!.startButton.text ="STOP"

        runnable = Runnable {
            if(seconds != 0){
                seconds--
            } else {
                seconds = 59
                mins--
            }
            updateTimer(mins,seconds)

            if(mins == 0 && seconds  == 0){
                onTimerStopped()

            }else{
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    private fun onTimerStopped() {
        binding!!.startButton.text ="START"
        handler.removeCallbacks(runnable)


        if(mode == "rest"){
            switchFocusMode()
        }
        else if(mode == "focus"){
            switchRestMode()
        }

        status = "wait"
    }


    private fun switchFocusMode() {
        mode = "focus"
        mins = initialMins
        seconds = initialSeconds
        updateTimer(mins,seconds)

        binding!!.pomodoroImage.setImageResource(R.drawable.pomodoro)
        binding!!.skipButton.visibility =  View.GONE
    }

    private fun switchRestMode() {
        mode = "rest"
        mins = restMins
        seconds = initialSeconds
        updateTimer(mins,seconds)

        binding!!.pomodoroImage.setImageResource(R.drawable.sleep)
        binding!!.skipButton.visibility =  View.VISIBLE
    }


    private fun updateTimer(mins: Int, seconds: Int) {
        binding!!.timer.text = mins.toString().padStart(2, '0') + " : " + seconds.toString().padStart(2, '0')
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

    }

}