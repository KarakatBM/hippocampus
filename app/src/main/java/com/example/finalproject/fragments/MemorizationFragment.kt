package com.example.finalproject.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentMemorizationBinding

class MemorizationFragment: Fragment() {
    private var binding: FragmentMemorizationBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentMemorizationBinding.inflate(inflater, container, false)

//      TODO: Add OnClick Handler for buttons

        return binding!!.root
    }
}