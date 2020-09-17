package com.wpaul15.cookbook.shared

class Ingredient(var name: String, var amount: Double, var unit: Unit) {

	override fun toString(): String = buildString {
		append(amount).append(' ').append(unit).append(' ').append(name)
	}
}