package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.finalproject.databinding.FragmentNotesBinding

class NotesFragment: Fragment() {
    private var binding: FragmentNotesBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate(inflater, container, false)

        //  TODO: Add OnClick Handler for Note Items

        // Add OnClick Handler for Add Flashcard button
        binding!!.addNoteButton.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_notesFragment_to_addNoteFragment) }

        return binding!!.root
    }
}