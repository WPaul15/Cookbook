package com.wpaul15.cookbook.shared

expect class Ingredient(name: String, amount: Double, measurement: Measurement) {

	override fun toString(): String
}
