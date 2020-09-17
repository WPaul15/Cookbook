package com.wpaul15.cookbook.androidApp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.androidApp.ui.recipe.RecipeActivity

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	fun openRecipeViewActivity(view: View) {
		val intent = Intent(this, RecipeActivity::class.java)
		startActivity(intent)
	}
}
