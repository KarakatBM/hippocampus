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
import com.example.finalproject.database.NotesApplication
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesDatabaseDao
import com.example.finalproject.database.PomodoroDatabase
import com.example.finalproject.viewmodel.AddNoteViewModelFactory
import com.example.finalproject.viewmodel.PomodoroViewModel
import com.example.finalproject.viewmodel.PomodoroViewModelFactory
//import com.example.finalproject.database.NotesApplication
class AddNoteFragment : Fragment() {
    private var binding: FragmentAddNoteBinding? = null
//    private val viewModel: AddNoteViewModel by viewModels()
//private val viewModel by lazy {
//    ViewModelProvider(this)[AddNoteViewModel::class.java]
//}

//private lateinit var viewModel: AddNoteViewModel

    companion object {
        const val EXTRA_REPLY = "com.example.android.notelistsql.REPLY"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)


//        val application = requireNotNull(this.activity).application
//
//        // Create an instance of the ViewModel Factory.
//        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao
//        val viewModelFactory = AddNoteViewModelFactory(dataSource, application)
//
//        // Get a reference to the ViewModel associated with this fragment.
//          viewModel =
//            ViewModelProvider(
//                this, viewModelFactory).get(AddNoteViewModel::class.java)

        binding!!.saveButton.setOnClickListener{ view: View->
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding!!.titleInput.text) || TextUtils.isEmpty(binding!!.descriptionInput.text) ) {
                activity?.setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val note = arrayListOf<String>(binding!!.titleInput.text.toString(), binding!!.descriptionInput.text.toString())
                replyIntent.putExtra(EXTRA_REPLY, note)
                activity?.setResult(Activity.RESULT_OK, replyIntent)
            }
             activity?.getFragmentManager()?.popBackStack();
//            getActivity()?.getFragmentManager()?.beginTransaction()?.remove(this as Fragment)?.commit();
      //      viewModel.insertIntoDatabase(0, binding!!.titleInput.text.toString(), binding!!.descriptionInput.text.toString())
              }





        return binding!!.root
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
}