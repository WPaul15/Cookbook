package com.wpaul15.cookbook.shared

import android.os.Parcel
import android.os.Parcelable

actual class Recipe actual constructor(
	private var name: String,
	val ingredients: MutableList<Ingredient>,
	val instructions: MutableList<String>
) : Parcelable {

	constructor(name: String) : this(name, mutableListOf<Ingredient>(), mutableListOf<String>())

	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		mutableListOf<Ingredient>().apply {
			parcel.readList(this, Ingredient::class.java.classLoader)
		},
		parcel.createStringArrayList()!!
	)

	actual fun addIngredient(ingredient: Ingredient) {
		this.ingredients.add(ingredient)
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

	actual override fun toString(): String = name

	override fun writeToParcel(parcel: Parcel?, flags: Int) {
		parcel?.let {
			it.writeString(name)
			it.writeList(ingredients)
			it.writeStringList(instructions)
		}
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Recipe> {

		override fun createFromParcel(parcel: Parcel): Recipe {
			return Recipe(parcel)
		}

		override fun newArray(size: Int): Array<Recipe?> {
			return arrayOfNulls(size)
		}
	}
}
