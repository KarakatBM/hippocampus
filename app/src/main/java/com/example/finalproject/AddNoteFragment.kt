package com.example.finalproject



import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.finalproject.database.Notes
import com.example.finalproject.database.PomodoroDatabase
import com.example.finalproject.databinding.FragmentAddNoteBinding
import com.example.finalproject.viewmodel.AddNoteViewModel
import com.example.finalproject.viewmodel.NotesViewModel
import com.example.finalproject.viewmodel.PomodoroViewModel
import com.example.finalproject.viewmodel.PomodoroViewModelFactory
import java.text.SimpleDateFormat
import java.util.*


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