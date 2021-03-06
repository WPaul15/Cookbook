package com.wpaul15.cookbook.androidApp.ui.main

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.databinding.ActivityMainBinding
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipeActivity
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipeViewModel
import com.wpaul15.cookbook.androidApp.ui.settings.SettingsActivity
import com.wpaul15.cookbook.shared.Ingredient
import com.wpaul15.cookbook.shared.Measurement
import com.wpaul15.cookbook.shared.Recipe
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CookbookApplication : Application()

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setSupportActionBar(binding.toolbarMain)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
		R.id.action_settings -> {
			openSettingsActivity()
			true
		}
		else -> super.onOptionsItemSelected(item)
	}

	fun openRecipeViewActivity(view: View) {
		val recipe = Recipe("Pancakes")
		recipe.addIngredient(0, Ingredient("Flour", 1.0, Measurement.CUP))
		recipe.addIngredient(1, Ingredient("Sugar", 1.0, Measurement.TABLESPOON))
		recipe.addInstruction(0, "Mix ingredients together in a medium mixing bowl until smooth")
		recipe.addInstruction(1, "Heat pan")
		recipe.addInstruction(2, "Add batter to pan")
		recipe.addNote(0, "Make sure not to let the pancakes cook for too long on either side")

		val intent = Intent(this, RecipeActivity::class.java).apply {
			putExtra(RecipeViewModel.RECIPE_KEY, recipe)
		}

		startActivity(intent)
	}

	fun openSettingsActivity() {
		startActivity(Intent(this, SettingsActivity::class.java))
	}
}
