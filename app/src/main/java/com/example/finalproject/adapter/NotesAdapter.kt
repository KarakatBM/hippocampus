package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.database.Notes

class NotesAdapter(val context: Context): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

	private val allNotes = ArrayList<Notes>()

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val noteText = itemView.findViewById<TextView>(R.id.note_text)
		val dateText = itemView.findViewById<TextView>(R.id.date_text)
		val deleteIcon = itemView.findViewById<ImageView>(R.id.delete_icon)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val itemView = LayoutInflater.from(parent.context).inflate(
			R.layout.fragment_note_item, parent, false)

		return ViewHolder(itemView)
	}


	override fun onBindViewHolder(holder: ViewHolder, id: Int) {

		holder.noteText.setText(allNotes.get(id).noteTitle)
		holder.dateText.setText("Last Updated : " + allNotes.get(id).timeStamp)

		holder.deleteIcon.setOnClickListener {
			onDeleteIconClick(allNotes.get(id))
		}

		holder.itemView.setOnClickListener {
			onNoteClick(allNotes.get(id))
		}
	}

	override fun getItemCount() = allNotes.size

}

	fun onDeleteIconClick(note: Notes) {

	}

	fun onNoteClick(note: Notes) {

	}

