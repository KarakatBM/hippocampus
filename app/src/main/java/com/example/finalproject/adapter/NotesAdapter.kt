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

class NotesAdapter(
	val context: Context,
	val noteClickDeleteInterface: NoteClickDeleteInterface,
	val noteClickInterface: NoteClickInterface): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

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


	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		holder.noteText.setText(allNotes.get(position).noteTitle)
		holder.dateText.setText("Last Updated : " + allNotes.get(position).timeStamp)

		holder.deleteIcon.setOnClickListener {
			noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
		}

		holder.itemView.setOnClickListener {
			noteClickInterface.onNoteClick(allNotes.get(position))
		}
	}

	override fun getItemCount() = allNotes.size

}

interface NoteClickDeleteInterface {
	fun onDeleteIconClick(note: Notes)
}

interface NoteClickInterface {
	fun onNoteClick(note: Notes)
}
