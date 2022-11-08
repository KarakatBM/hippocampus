package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.databinding.FragmentHomePageBinding
import com.example.finalproject.databinding.FragmentToolbarBinding

class HomePageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        val binding: ViewDataBinding? = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_page, container, false)

        // Add OnClick Handler for CardViews
        binding?.root?.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_homePageFragment_to_foldersPageFragment) }

        //   TODO: Implement other handlers

        binding?.root?.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_homePageFragment_to_notesFragment) }

            return binding!!.root
    }
}