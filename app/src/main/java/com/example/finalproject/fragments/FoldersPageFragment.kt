package com.example.finalproject.fragments



import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
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
        // Add OnClick Handler for Add Folder button
        binding!!.addModule.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(FoldersPageFragmentDirections.actionFoldersPageFragmentToPlaceholder()) }

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
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.nav_menu2, menu)
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.
//        onNavDestinationSelected(item,requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }

}