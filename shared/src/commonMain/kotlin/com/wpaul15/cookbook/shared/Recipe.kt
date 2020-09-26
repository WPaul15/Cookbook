package com.wpaul15.cookbook.shared

expect class Recipe(
	name: String,
	ingredients: MutableList<Ingredient> = mutableListOf(),
	instructions: MutableList<String> = mutableListOf(),
	notes: MutableList<String> = mutableListOf()
) {

	fun addIngredient(index: Int, ingredient: Ingredient)

	fun removeIngredient(index: Int)

	fun addInstruction(index: Int, instruction: String)

	fun removeInstruction(index: Int)

	fun addNote(index: Int, note: String)

	fun removeNote(index: Int)

	override fun toString(): String
}
