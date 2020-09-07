package com.wpaul15.cookbook.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wpaul15.cookbook.shared.Ingredient
import com.wpaul15.cookbook.shared.Recipe
import com.wpaul15.cookbook.shared.Unit
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        val random = Random()
        val recipe = Recipe("Test Recipe")

        for (i in 0..2) {
            recipe.addIngredient(Ingredient("Ingredient $i", random.nextDouble(), Unit.CUP))
        }

        tv.text = recipe.toString()
    }
}
