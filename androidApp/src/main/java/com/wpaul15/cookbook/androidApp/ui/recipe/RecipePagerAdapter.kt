package com.wpaul15.cookbook.androidApp.ui.recipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wpaul15.cookbook.shared.Recipe

class RecipePagerAdapter(
	fragmentActivity: FragmentActivity,
	private val numTabs: Int,
	private val recipe: Recipe
) :
	FragmentStateAdapter(fragmentActivity) {

	override fun getItemCount(): Int = numTabs

	override fun createFragment(position: Int): Fragment =
		when (position) {
			0 -> IngredientsFragment.newInstance(recipe)
			1 -> PreparationFragment.newInstance(recipe)
			2 -> IngredientsFragment.newInstance(recipe)
			else -> throw Exception("Invalid tab")
		}
}
