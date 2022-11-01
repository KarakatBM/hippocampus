package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.Todo

class TodoItemAdapter(private val context: Context, private val dataset:List<Todo>) : RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {

    class TodoItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val todoTextView: TextView = view.findViewById(R.id.todo_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_item, parent, false)

        return TodoItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.todoTextView.text =  context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount() = dataset.size
}