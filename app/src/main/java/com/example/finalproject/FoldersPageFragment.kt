package com.example.finalproject



import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.adapter.ModulesItemAdapter
import com.example.finalproject.data.DatasourceModules
import com.example.finalproject.databinding.FragmentFoldersPageBinding


class FoldersPageFragment : Fragment() {

    private var binding: FragmentFoldersPageBinding? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ModulesItemAdapter.ItemViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentFoldersPageBinding.inflate(inflater, container, false)


//        binding!!.folder.setOnClickListener { view: View->
//            view.findNavController()
//                .navigate(R.id.action_foldersPageFragment_to_flashcardPageFragment) }
//
//        // Add OnClick Handler for Add Folder button
//        binding!!.addFolderButton.setOnClickListener{ view: View->
//            view.findNavController()
//                .navigate(R.id.action_foldersPageFragment_to_placeholder) }

//        TODO: Delete placeholder, put add_folder_page instead
        // Initialize data.

        
        return binding!!.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val myDataset = DatasourceModules().loadmodules()
        binding?.modulesRecyclerView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = ModulesItemAdapter(context,myDataset)
        }
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val myDataset = DatasourceModules().loadmodules()
//
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.adapter = ModulesItemAdapter(context, myDataset)
//
//        recyclerView.setHasFixedSize(true)
//    }
////    override fun onAttach(context: Context?) {
////        super.onAttach(context)
////        context = activity
////    }
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//    }
}