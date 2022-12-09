package com.example.finalproject.fragments





import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.finalproject.databinding.FragmentPomodoroBinding
import android.os.Handler
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.database.PomodoroDatabase
import com.example.finalproject.viewmodel.PomodoroViewModel
import com.example.finalproject.viewmodel.PomodoroViewModelFactory

class PomodoroFragment : Fragment() {
    private val viewModel: PomodoroViewModel by viewModels()
    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable


    private var binding: FragmentPomodoroBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentPomodoroBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = PomodoroDatabase.getInstance(application).pomodoroDatabaseDao
        val viewModelFactory = PomodoroViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val pomodoroViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(PomodoroViewModel::class.java)


        //initial timer 25 mins
        binding!!.startButton.setOnClickListener{
            if(viewModel.status.value == "wait"){
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

//       TODO: Fix the problems  [pathway 9.2.4]

//        Set the current activity as the lifecycle owner of the binding
//        binding!!.setLifecycleOwner(this)
//        binding!!.pomodoroViewModel = pomodoroViewModel

        return binding!!.root
    }

    private fun handleSkipButton() {
        switchFocusMode()
    }

    override fun onStart() {
        super.onStart()
        updateTimer(viewModel.mins.value!!,viewModel.seconds.value!!)
    }

    private fun handleTimerLength() {
       viewModel.handleTimerLength()
    }

    private fun onTimerStarted() {
        viewModel.setStartStatus()
        binding!!.startButton.text ="STOP"

        runnable = Runnable {
            viewModel.decreaseTimer()

            if(viewModel.mins.value == 0 && viewModel.seconds.value  == 0){
                onTimerStopped()
            }else{
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    private fun onTimerStopped() {
        viewModel.setStopStatus()
        binding!!.startButton.text ="START"
        handler.removeCallbacks(runnable)


        when(viewModel.mode.value){
            "focus" ->  switchRestMode()
            "rest" ->  switchFocusMode()
            else -> print("OK")
        }

    }


    private fun switchFocusMode() {
        viewModel.setModeFocus()
        viewModel.resetFocusTimer()

//        updateTimer(mins,seconds)

        binding!!.pomodoroImage.setImageResource(R.drawable.pomodoro)
        binding!!.skipButton.visibility =  View.GONE
    }

    private fun switchRestMode() {
        viewModel.setModeRest()
        viewModel.resetRestTimer()

        binding!!.pomodoroImage.setImageResource(R.drawable.sleep)
        binding!!.skipButton.visibility =  View.VISIBLE
    }


    private fun updateTimer(mins: Int, seconds: Int) {
        binding!!.timer.text = mins.toString().padStart(2, '0') + " : " + seconds.toString().padStart(2, '0')
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        viewModel.seconds.observe(viewLifecycleOwner
        ) { newSecond ->
            updateTimer(viewModel.mins.value!!, newSecond)
        }
        if(viewModel.status.value=="start"){
            onTimerStarted()
        }
    }

}