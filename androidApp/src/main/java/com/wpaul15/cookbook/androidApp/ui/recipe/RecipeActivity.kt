package com.wpaul15.cookbook.androidApp.ui.recipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.databinding.ActivityRecipeBinding
import com.wpaul15.cookbook.shared.Recipe
import dagger.hilt.android.AndroidEntryPoint

private val TAB_TITLES = arrayOf(
	R.string.tab_ingredients,
	R.string.tab_preparation,
	R.string.tab_notes,
)

@AndroidEntryPoint
class RecipeActivity : AppCompatActivity() {

	private lateinit var binding: ActivityRecipeBinding
	private lateinit var recipePagerAdapter: RecipePagerAdapter
	private lateinit var viewPager: ViewPager2

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityRecipeBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setSupportActionBar(binding.toolbarRecipe)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val recipe = intent.extras?.get(RecipeViewModel.RECIPE_KEY) as Recipe

		recipePagerAdapter = RecipePagerAdapter(this, TAB_TITLES.size, recipe)
		viewPager = binding.viewPager
		viewPager.adapter = recipePagerAdapter

		val tabLayout = binding.tabsRecipe
		TabLayoutMediator(tabLayout, viewPager) { tab, position ->
			tab.text = resources.getString(TAB_TITLES[position])
		}.attach()

		val fab: FloatingActionButton = binding.fab

		fab.setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				.setAction("Action", null).show()
		}
	}
}
