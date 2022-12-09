package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.FoldersPageFragmentDirections
import com.example.finalproject.NotesFragmentDirections
import com.example.finalproject.R
import com.example.finalproject.database.Notes
import com.example.finalproject.model.Note
class NoteItemAdapter(val context: Context,  private val dataset:List<Note>): RecyclerView.Adapter<NoteItemAdapter.NoteItemViewHolder>() {



    inner class NoteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.note_text)
        val dateText = itemView.findViewById<TextView>(R.id.date_text)
        val deleteIcon = itemView.findViewById<ImageView>(R.id.delete_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_note_item, parent, false)

        return NoteItemViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {

        val item = dataset[position]
        holder.titleText.text =  item.title
        holder.dateText.text =  item.date

        holder.deleteIcon.setOnClickListener {
            onDeleteIconClick(dataset.get(position))
        }

        holder.itemView.setOnClickListener {
            onNoteClick(dataset[position], holder)
        }

    }

    override fun getItemCount() = dataset.size
    private fun onDeleteIconClick(note: Note) {

    }

    private fun onNoteClick(note: Note,holder: NoteItemViewHolder) {
        val action = NotesFragmentDirections.actionNotesFragmentToItemViewNote(note.description,note.title, note.date)
        holder.itemView.findNavController().navigate(action)
    }

}



