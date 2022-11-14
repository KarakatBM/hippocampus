package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.FoldersPageFragmentDirections
import com.example.finalproject.R
import com.example.finalproject.model.Modules


class ModulesItemAdapter(private val context: Context, private val dataset: List<Modules>) : RecyclerView.Adapter<ModulesItemAdapter.ItemViewHolder>() {
    class ItemViewHolder( val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.modules_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.textView.setOnClickListener{
            val action = FoldersPageFragmentDirections.actionFoldersPageFragmentToFolderFragment()
            holder.view.findNavController().navigate(action)
        }
//        holder.textView.setOnClickListener{
//            val action = FoldersPageFragmentDirections.action
//        }
//        val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
//        // Navigate using that action
//        holder.view.findNavController().navigate(action)
    }

    override fun getItemCount() = dataset.size
}