package com.wpaul15.cookbook.androidApp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openRecipeViewActivity(view: View) {
        val intent = Intent(this, RecipeViewActivity::class.java)
        startActivity(intent)
    }
}
