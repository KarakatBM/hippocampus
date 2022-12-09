package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.finalproject.database.Notes
import com.example.finalproject.databinding.FragmentAddNoteBinding
import com.example.finalproject.viewmodel.NotesViewModel
import java.text.SimpleDateFormat
import java.util.*


class AddNoteFragment : Fragment() {
    private var binding: FragmentAddNoteBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)


        binding!!.addNoteButton.setOnClickListener{ view: View->
            view.findNavController()
//                .navigate(R.id.action_notesFragment_to_addNoteFragment)

        }

        return binding!!.root
    }
}