package com.wpaul15.cookbook.androidApp.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.shared.Ingredient
import com.wpaul15.cookbook.shared.Recipe

class RecipeViewAdapter(private val recipe: Recipe) :
	RecyclerView.Adapter<RecipeViewAdapter.IngredientViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
		IngredientViewHolder(LayoutInflater.from(parent.context), parent)

	override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
		holder.bind(recipe.ingredients[position])
	}

	override fun getItemCount(): Int = recipe.ingredients.size

	class IngredientViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
		RecyclerView.ViewHolder(inflater.inflate(R.layout.view_holder_ingredient, parent, false)) {

		private var textIngredient: TextView = itemView.findViewById(R.id.text_ingredient)

		fun bind(ingredient: Ingredient) {
			textIngredient.text = "$ingredient"
		}
	}
}