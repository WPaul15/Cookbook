package com.wpaul15.cookbook.androidApp.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.shared.Recipe

class PreparationViewAdapter(private val recipe: Recipe) :
	RecyclerView.Adapter<PreparationViewAdapter.PreparationViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreparationViewHolder =
		PreparationViewHolder(LayoutInflater.from(parent.context), parent)

	override fun onBindViewHolder(holder: PreparationViewHolder, position: Int) {
		holder.bind(position, recipe.instructions[position])
	}

	override fun getItemCount(): Int = recipe.instructions.size

	class PreparationViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
		RecyclerView.ViewHolder(inflater.inflate(R.layout.view_holder_ingredient, parent, false)) {

		private var textStepNumber: TextView = itemView.findViewById(R.id.text_step_number)
		private var textInstruction: TextView = itemView.findViewById(R.id.text_instruction)

		fun bind(index: Int, instruction: String) {
			textStepNumber.text = "$index"
			textInstruction.text = instruction
		}
	}
}