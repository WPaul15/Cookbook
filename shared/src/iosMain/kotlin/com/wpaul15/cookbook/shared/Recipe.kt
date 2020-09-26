package com.wpaul15.cookbook.shared

actual class Recipe actual constructor(
	private var name: String,
	val ingredients: MutableList<Ingredient>,
	val instructions: MutableList<String>,
	val notes: MutableList<String>
) {

	actual fun addIngredient(index: Int, ingredient: Ingredient) {
		this.ingredients.add(index, ingredient)
	}

	actual fun removeIngredient(index: Int) {
		this.ingredients.removeAt(index)
	}

	actual fun addInstruction(index: Int, instruction: String) {
		this.instructions.add(index, instruction)
	}

	actual fun removeInstruction(index: Int) {
		this.instructions.removeAt(index)
	}

	actual fun addNote(index: Int, note: String) {
		this.notes.add(index, note)
	}

	actual fun removeNote(index: Int) {
		this.notes.removeAt(index)
	}

	actual override fun toString(): String {
		return buildString {
			append(name).append('\n')

			for (ingredient in ingredients) {
				append(ingredient.toString()).append('\n')
			}
		}
	}
}
