package com.wpaul15.cookbook.androidApp.ui.recipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class RecipePagerAdapter(fragmentActivity: FragmentActivity, private val numTabs: Int) :
	FragmentStateAdapter(fragmentActivity) {

	override fun getItemCount(): Int = numTabs

	override fun createFragment(position: Int): Fragment =
		when (position) {
			0, 2 -> IngredientsFragment.newInstance(position + 1)
			1 -> PreparationFragment.newInstance(position + 1)
			else -> throw Exception("Invalid tab")
		}
}
