package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.QuestionAnswer


class ModuleInnerItemAdapter(private val context: Context, private val dataset: List<QuestionAnswer>) : RecyclerView.Adapter<ModuleInnerItemAdapter.ItemViewHolder>() {
    class ItemViewHolder( val view: View) : RecyclerView.ViewHolder(view) {
        val textViewQ: TextView = view.findViewById(R.id.question_container)
        val textViewA: TextView = view.findViewById(R.id.answer_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.folder_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textViewQ.text = context.resources.getString(item.string1ResourceId)
        holder.textViewA.text = context.resources.getString(item.string2ResourceId)
    }

    override fun getItemCount() = dataset.size
}