package com.example.finalproject.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentItemViewNoteBinding


class ItemViewNote : Fragment() {
    private var binding: FragmentItemViewNoteBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val args = ItemViewNoteArgs.fromBundle(requireArguments())
        // Inflate the layout for this fragment
        binding = FragmentItemViewNoteBinding.inflate(inflater, container, false)
        binding!!.descriptionoutput.text = args.notedescription
        binding!!.titleoutput.text = args.notetitle
        binding!!.timeoutput.text = args.notedate
        //  TODO: Add OnClick Handler for Notes items


        return binding!!.root
    }

}