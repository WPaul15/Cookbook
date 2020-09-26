package com.wpaul15.cookbook.shared

enum class Measurement(private val unit: String) {
	NONE(""),
	TEASPOON("Teaspoon (tsp)"),
	TABLESPOON("Tablespoon (Tbsp)"),
	FLUID_OUNCE("Fluid Ounce (fl oz)"),
	CUP("Cup (C)"),
	PINT("Pint (pt)"),
	QUART("Quart (qt)"),
	GALLON("Gallon (gal)"),
	OUNCE("Ounce (oz)"),
	POUND("Pound (lb)"),
	PINCH("Pinch (pn)"),
	DASH("Dash (ds)"),
	GRAM("Gram (g)"),
	KILOGRAM("Kilogram (kg)"),
	MILLILITER("Milliliter (mL)"),
	LITER("Liter (L)"),
	;

	override fun toString(): String {
		return unit
	}
}
