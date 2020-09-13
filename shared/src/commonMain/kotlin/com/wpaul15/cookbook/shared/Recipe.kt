package com.wpaul15.cookbook.shared

class Recipe(var name: String) {

	private val ingredients = mutableListOf<Ingredient>()

	fun addIngredient(ingredient: Ingredient) {
		this.ingredients.add(ingredient)
	}

	fun removeIngredient(ingredient: Ingredient) {
		this.ingredients.remove(ingredient)
	}

	override fun toString(): String {
		return buildString {
			append(name).append('\n')

			for (ingredient in ingredients) {
				append(ingredient.toString()).append('\n')
			}
		}
	}
}