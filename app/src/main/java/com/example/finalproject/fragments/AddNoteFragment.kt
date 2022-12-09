package com.example.finalproject.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentAddNoteBinding
import com.example.finalproject.viewmodel.AddNoteViewModel


class AddNoteFragment : Fragment() {
    private var binding: FragmentAddNoteBinding? = null
    private val viewModel: AddNoteViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)


        binding!!.addNoteButton.setOnClickListener{ view: View->
            viewModel.insertIntoDatabase(0, binding!!.titleInput.text.toString(), binding!!.descriptionInput.text.toString())

            view.findNavController()
                .navigate(R.id.action_notesFragment_to_addNoteFragment)}
        return binding!!.root
    }
}