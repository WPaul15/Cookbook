package com.wpaul15.cookbook.androidApp.ui.main

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipeActivity
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipeViewModel
import com.wpaul15.cookbook.shared.Ingredient
import com.wpaul15.cookbook.shared.Measurement
import com.wpaul15.cookbook.shared.Recipe
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CookbookApplication : Application()

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	fun openRecipeViewActivity(view: View) {
		val recipe = Recipe("Pancakes")
		recipe.addIngredient(Ingredient("Flour", 1.0, Measurement.CUP))
		recipe.addIngredient(Ingredient("Sugar", 1.0, Measurement.TABLESPOON))
		recipe.addInstruction(0, "Mix ingredients together in a medium mixing bowl until smooth")
		recipe.addInstruction(1, "Heat pan")
		recipe.addInstruction(2, "Add batter to pan")

		val intent = Intent(this, RecipeActivity::class.java).apply {
			putExtra(RecipeViewModel.RECIPE_KEY, recipe)
		}

		startActivity(intent)
	}
}
