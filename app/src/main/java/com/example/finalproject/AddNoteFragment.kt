package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {
    private var binding: FragmentAddNoteBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        //  TODO: Add OnClick Handler for Add Note button


        return binding!!.root
    }
}