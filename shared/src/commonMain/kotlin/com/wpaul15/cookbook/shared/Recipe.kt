package com.wpaul15.cookbook.shared

expect class Recipe(
	name: String,
	ingredients: MutableList<Ingredient> = mutableListOf(),
	instructions: MutableList<String> = mutableListOf()
) {

	fun addIngredient(ingredient: Ingredient)

	fun removeIngredient(index: Int)

	fun addInstruction(index: Int, instruction: String)

	fun removeInstruction(index: Int)

	override fun toString(): String
}
