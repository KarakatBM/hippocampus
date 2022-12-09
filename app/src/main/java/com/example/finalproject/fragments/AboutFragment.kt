package com.example.finalproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalproject.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {
    private var binding: FragmentAboutBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       binding = FragmentAboutBinding.inflate(inflater, container, false)



        return binding!!.root
    }
}