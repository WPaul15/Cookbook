package com.wpaul15.cookbook.shared

class Ingredient(var name: String, var amount: Double, var unit: Unit) {

	override fun toString(): String {
		return buildString {
			append(name).append(' ').append(amount).append(' ').append(unit)
		}
	}
}