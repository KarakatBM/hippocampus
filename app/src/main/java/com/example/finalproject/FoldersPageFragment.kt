package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController

import com.example.finalproject.databinding.FragmentFoldersPageBinding


class FoldersPageFragment : Fragment() {

    private var binding: FragmentFoldersPageBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentFoldersPageBinding.inflate(inflater, container, false)


        binding!!.folder.setOnClickListener { view: View->
            view.findNavController()
                .navigate(R.id.action_foldersPageFragment_to_flashcardPageFragment) }

        // Add OnClick Handler for Add Folder button
        binding!!.addFolderButton.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_foldersPageFragment_to_placeholder) }

//        TODO: Delete placeholder, put add_folder_page instead
        
        return binding!!.root
    }
}