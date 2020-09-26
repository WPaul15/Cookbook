package com.wpaul15.cookbook.shared

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
actual data class Ingredient actual constructor(
	var name: String,
	var amount: Double,
	var measurement: Measurement
) : Parcelable {

	actual override fun toString(): String = buildString {
		append(amount).append(' ').append(measurement).append(' ').append(name)
	}
}
