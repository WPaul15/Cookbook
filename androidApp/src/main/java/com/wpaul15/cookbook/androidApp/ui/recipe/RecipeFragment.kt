package com.wpaul15.cookbook.androidApp.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.databinding.FragmentIngredientsBinding
import com.wpaul15.cookbook.shared.Ingredient
import com.wpaul15.cookbook.shared.Recipe
import com.wpaul15.cookbook.shared.Unit

class RecipeFragment : Fragment() {

	private var _binding: FragmentIngredientsBinding? = null
	private val binding get() = _binding!!

	private lateinit var recyclerView: RecyclerView
	private lateinit var viewAdapter: RecyclerView.Adapter<*>
	private lateinit var viewManager: RecyclerView.LayoutManager

	private val recipeViewModel: RecipeViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// Can be removed later
		recipeViewModel.apply { setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) }
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentIngredientsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val recipe = Recipe("Recipe 1")
		recipe.addIngredient(Ingredient("Flour", 1.0, Unit.CUP))
		recipe.addIngredient(Ingredient("Sugar", 1.0, Unit.TABLESPOON))


		viewManager = LinearLayoutManager(view.context)
		viewAdapter = RecipeViewAdapter(recipe)

		recyclerView = binding.recyclerViewRecipe.apply {
			setHasFixedSize(true)
			layoutManager = viewManager
			adapter = viewAdapter
			addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	companion object {

		private const val ARG_SECTION_NUMBER = "section_number"

		fun newInstance(sectionNumber: Int): RecipeFragment {
			return RecipeFragment().apply {
				arguments = Bundle().apply {
					putInt(ARG_SECTION_NUMBER, sectionNumber)
				}
			}
		}
	}
}