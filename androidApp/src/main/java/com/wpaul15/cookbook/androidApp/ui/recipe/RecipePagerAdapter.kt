package com.wpaul15.cookbook.androidApp.ui.recipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview.RecyclerViewFragment
import com.wpaul15.cookbook.shared.Recipe
import kotlinx.android.synthetic.main.view_holder_ingredient.view.*

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
			) {
				text_ingredient.text = "$it"
			}
			1 -> PreparationFragment.newInstance(recipe)
			2 -> NotesFragment.newInstance(recipe)
			else -> throw Exception("Invalid tab")
		}
}
