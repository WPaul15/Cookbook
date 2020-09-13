package com.wpaul15.cookbook.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipePagerAdapter

private val TAB_TITLES = arrayOf(
	R.string.tab_ingredients,
	R.string.tab_preparation,
	R.string.tab_notes,
)

class RecipeActivity : AppCompatActivity() {

	private lateinit var recipePagerAdapter: RecipePagerAdapter
	private lateinit var viewPager: ViewPager2

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_recipe)
		recipePagerAdapter = RecipePagerAdapter(this, TAB_TITLES.size)
		viewPager = findViewById(R.id.view_pager)
		viewPager.adapter = recipePagerAdapter

		val tabLayout = findViewById<TabLayout>(R.id.tabs)
		TabLayoutMediator(tabLayout, viewPager) { tab, position ->
			tab.text = resources.getString(TAB_TITLES[position])
		}.attach()

		val fab: FloatingActionButton = findViewById(R.id.fab)

		fab.setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				.setAction("Action", null).show()
		}
	}
}