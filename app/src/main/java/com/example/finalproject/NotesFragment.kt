package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.finalproject.adapter.NoteItemAdapter
import com.example.finalproject.data.DatasourseNote
import com.example.finalproject.database.Notes
import com.example.finalproject.databinding.FragmentNotesBinding
import com.example.finalproject.viewmodel.NotesViewModel

class NotesFragment: Fragment() {
    private var binding: FragmentNotesBinding? = null

    private lateinit var viewModel: NotesViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<NoteItemAdapter.NoteItemViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate(inflater, container, false)



        // setting layout manager to recycler view.
//        notesRV.layoutManager = LinearLayoutManager(this)

        // initializing adapter class.
//        val noteRVAdapter = NotesAdapter(this)
        // setting adapter to recycler view.
//        notesRV.adapter = noteRVAdapter

//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(NotesViewModel::class.java)


        //  TODO: Add OnClick Handler for Note Items

        // Add OnClick Handler for Add Flashcard button
        binding!!.addNoteButton.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_notesFragment_to_addNoteFragment)
        }

        return binding!!.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val myDataset = DatasourseNote().loadnotes()
        binding!!
        binding?.notesRecyclerView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = NoteItemAdapter(context,myDataset)
        }
    }

    fun onDeleteIconClick(note: Notes) {
        viewModel.deleteNote(note)
    }
}