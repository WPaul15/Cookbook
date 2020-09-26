package com.wpaul15.cookbook.androidApp.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.shared.Recipe

class NotesViewAdapter(private val recipe: Recipe) :
	RecyclerView.Adapter<NotesViewAdapter.NoteViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
		NoteViewHolder(LayoutInflater.from(parent.context), parent)

	override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
		holder.bind(recipe.notes[position])
	}

	override fun getItemCount(): Int = recipe.notes.size

	class NoteViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
		RecyclerView.ViewHolder(inflater.inflate(R.layout.view_holder_note, parent, false)) {

		private val textNote: TextView = itemView.findViewById(R.id.text_note)

		fun bind(note: String) {
			textNote.text = note
		}
	}
}
