package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.adapter.ModuleInnerItemAdapter
import com.example.finalproject.adapter.ModulesItemAdapter
import com.example.finalproject.data.DatasourseModuleInner
import com.example.finalproject.databinding.FragmentFolderBinding
import com.example.finalproject.databinding.FragmentFoldersPageBinding

class FolderFragment : Fragment() {
    private var binding: FragmentFolderBinding? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ModuleInnerItemAdapter.ItemViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentFolderBinding.inflate(inflater, container, false)


//        binding!!.addModule.setOnClickListener{ view: View->
//            view.findNavController()
//                .navigate(R.id.action_foldersPageFragment_to_placeholder) }


        return binding!!.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val myDataset = DatasourseModuleInner().loadquestionanswers()
        binding?.folderRecyclerView?.apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = ModuleInnerItemAdapter(context,myDataset)
        }
    }

}
