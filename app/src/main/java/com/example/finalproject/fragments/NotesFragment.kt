package com.example.finalproject.fragments



import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.finalproject.R

import com.example.finalproject.adapter.NoteItemAdapter
import com.example.finalproject.data.DatasourseNote
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesApplication
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesDatabaseDao
import com.example.finalproject.databinding.FragmentNotesBinding
import com.example.finalproject.model.Note
import com.example.finalproject.viewmodel.AddNoteViewModel
import com.example.finalproject.viewmodel.AddNoteViewModelFactory
import com.example.finalproject.viewmodel.NotesViewModel
import com.example.finalproject.viewmodel.NotesViewModelFactory
import kotlinx.android.synthetic.main.fragment_home_page.*

class NotesFragment: Fragment() {

    private lateinit var notesDao: NotesDatabaseDao
    private lateinit var db: NotesDatabase

    private var binding: FragmentNotesBinding? = null





    private  var application:Application?= null
    private val viewModel: NotesViewModel by viewModels {
            NotesViewModelFactory((application as NotesApplication).repository)
        }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<NoteItemAdapter.NoteItemViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        application = requireNotNull(this.activity).application
//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(NotesViewModel::class.java)

        // setting layout manager to recycler view.
//        notesRV.layoutManager = LinearLayoutManager(this)

        // initializing adapter class.
//        val noteRVAdapter = NotesAdapter(this)
        // setting adapter to recycler view.
//        notesRV.adapter = noteRVAdapter




        //  TODO: Add OnClick Handler for Note Items

        // Add OnClick Handler for Add Flashcard button
        binding!!.addNoteButton.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(NotesFragmentDirections.actionNotesFragmentToAddNoteFragment())
        }




        return binding!!.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        viewModel.allNotes.observe(viewLifecycleOwner) { list ->
            Log.i("ok", "updated")
            binding!!
            binding?.notesRecyclerView?.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter = NoteItemAdapter(context,getList())
            }
        }
        var myDataset:List<Note> = when(viewModel.allNotes.value == null){
            true -> DatasourseNote().loadnotes()
            false -> getList()
        }
        Log.i("ok", "inside onViewCreated")
        if(viewModel.allNotes.value == null){
            Log.i("ok", ("null"))
        }else{
            Log.i("ok", ("not null"))
        }
        binding!!
        binding?.notesRecyclerView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = NoteItemAdapter(context,myDataset)
        }
    }
    private fun getList(): List<Note> {
        var list:MutableList<Note> = mutableListOf()
        for (x in viewModel.allNotes.value!!) {
           val note = Note(x.noteTitle,x.noteDescription,x.timeStamp)
            list.add(note)
        }
        return list
    }
    fun onDeleteIconClick(note: Notes) {
        viewModel.deleteNote(note)
    }
}


