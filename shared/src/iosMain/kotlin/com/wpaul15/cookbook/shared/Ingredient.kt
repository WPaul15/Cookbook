package com.wpaul15.cookbook.shared

actual data class Ingredient actual constructor(
	var name: String,
	var amount: Double,
	var measurement: Measurement
) {

	actual override fun toString(): String = buildString {
		append(amount).append(' ').append(measurement).append(' ').append(name)
	}
}
