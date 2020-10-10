package com.wpaul15.cookbook.androidApp.ui.recipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview.RecyclerViewFragment
import com.wpaul15.cookbook.shared.Recipe
import kotlinx.android.synthetic.main.view_holder_ingredient.view.*
import kotlinx.android.synthetic.main.view_holder_note.view.*
import kotlinx.android.synthetic.main.view_holder_preparation.view.*

class RecipePagerAdapter(
	fragmentActivity: FragmentActivity,
	private val numTabs: Int,
	private val recipe: Recipe
) : FragmentStateAdapter(fragmentActivity) {

	override fun getItemCount(): Int = numTabs

	override fun createFragment(position: Int): Fragment =
		when (position) {
			0 -> RecyclerViewFragment.newInstance(
				recipe.ingredients,
				R.layout.view_holder_ingredient
			) { _, item ->
				text_ingredient.text = "$item"
			}
			1 -> RecyclerViewFragment.newInstance(
				recipe.instructions,
				R.layout.view_holder_preparation
			) { position, item ->
				text_step_number.text = "${position + 1}"
				text_instruction.text = item
			}
			2 -> RecyclerViewFragment.newInstance(
				recipe.notes,
				R.layout.view_holder_note
			) { _, item ->
				text_note.text = item
			}
			else -> throw Exception("Invalid tab")
		}
}
