package com.wpaul15.cookbook.androidApp.ui.recipe

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wpaul15.cookbook.shared.Recipe

class RecipeViewModel @ViewModelInject constructor(
	@Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

	companion object {

		const val RECIPE_KEY = "com.wpaul15.cookbook.RECIPE"
	}

	private val recipeLiveData = savedStateHandle.getLiveData<Recipe>(RECIPE_KEY)

	fun getRecipe(): Recipe? = recipeLiveData.value

//	private val index = MutableLiveData<Int>()
//	val text: LiveData<String> = Transformations.map(index) {
//		"Hello world from section: $it"
//	}
//
//	fun setIndex(index: Int) {
//		this.index.value = index
//	}
}
