package com.wpaul15.cookbook.shared

class Recipe(var name: String) {

	val ingredients = mutableListOf<Ingredient>()
	val instructions = mutableListOf<String>()

	fun addIngredient(ingredient: Ingredient) {
		this.ingredients.add(ingredient)
	}

	fun removeIngredient(index: Int) {
		this.ingredients.removeAt(index)
	}

	fun addInstruction(index: Int, instruction: String) {
		this.instructions.add(index, instruction)
	}

	fun removeInstruction(index: Int) {
		this.instructions.removeAt(index)
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