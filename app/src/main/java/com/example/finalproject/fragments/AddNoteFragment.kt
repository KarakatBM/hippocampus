package com.example.finalproject.fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentAddNoteBinding
import com.example.finalproject.overview.OverviewViewModel
import com.example.finalproject.viewmodel.AddNoteViewModel
import androidx.lifecycle.Observer
import android.view.*
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.database.*
import com.example.finalproject.viewmodel.AddNoteViewModelFactory
import com.example.finalproject.viewmodel.PomodoroViewModel
import com.example.finalproject.viewmodel.PomodoroViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

//    private val viewModel: AddNoteViewModel by viewModels()
//private val viewModel by lazy {
//    ViewModelProvider(this)[AddNoteViewModel::class.java]
//}

//private lateinit var viewModel: AddNoteViewModel
//import com.example.finalproject.database.NotesApplication


class AddNoteFragment : Fragment() {
    private var binding: FragmentAddNoteBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)


        val application = requireNotNull(this.activity).application

//
//        // Create an instance of the ViewModel Factory.
        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao()
        val viewModelFactory = AddNoteViewModelFactory((application as NotesApplication).repository)
//
//        // Get a reference to the ViewModel associated with this fragment.
        val viewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(AddNoteViewModel::class.java)

        binding!!.saveButton.setOnClickListener { view: View ->
            val replyIntent = Intent()
            Log.i("ok", "Savebutton triggered")
            if (TextUtils.isEmpty(binding!!.titleInput.text) || TextUtils.isEmpty(binding!!.descriptionInput.text)) {
                Log.i("ok", "request canceled")

            } else {
                Log.i("ok", "request created")
                val note = Notes(
                    binding!!.titleInput.text.toString(),
                    binding!!.descriptionInput.text.toString(),
                    generateDate()
                )
                viewModel.insert(note)
                viewModel.allNotes.observe(viewLifecycleOwner) { list ->
                    for (x in list) {
                        Log.i("ok", x.noteTitle)
                    }
                }
            }
        }


        //            getActivity()?.getFragmentManager()?.beginTransaction()?.remove(this as Fragment)?.commit();
        //      viewModel.insertIntoDatabase(0, binding!!.titleInput.text.toString(), binding!!.descriptionInput.text.toString())
        return binding!!.root
    }

    private fun generateDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        return currentDate
    }

}


//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(itemView, savedInstanceState)
//        viewModel.isValid.observe(viewLifecycleOwner
//        ) { isVal ->
////            if(isVal == true){
////                this.requireView().findNavController().navigate(AddNoteFragmentDirections.actionAddNoteFragmentToItemViewNote("j","l","j"))
////            }
//            Log.i("addnotes","ok")
//        }
//
//    }