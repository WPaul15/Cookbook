package com.wpaul15.cookbook.androidApp.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.databinding.FragmentPreparationBinding
import com.wpaul15.cookbook.shared.Recipe

class PreparationFragment : Fragment() {

	private var _binding: FragmentPreparationBinding? = null
	private val binding get() = _binding!!

	private lateinit var recyclerView: RecyclerView
	private lateinit var viewAdapter: RecyclerView.Adapter<*>
	private lateinit var viewManager: RecyclerView.LayoutManager

	private val recipeViewModel: RecipeViewModel by activityViewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		recipeViewModel.apply { setIndex(arguments?.getInt(ARG_RECIPE) ?: 1) }
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentPreparationBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewManager = LinearLayoutManager(view.context)
		viewAdapter = PreparationViewAdapter(Recipe("Test"))

		recyclerView = binding.recyclerViewPreparation.apply {
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

		private const val ARG_RECIPE = "recipe"

		fun newInstance(sectionNumber: Int): PreparationFragment =
			PreparationFragment().apply {
				arguments = Bundle().apply {
					putInt(ARG_RECIPE, sectionNumber)
				}
			}
	}

}
