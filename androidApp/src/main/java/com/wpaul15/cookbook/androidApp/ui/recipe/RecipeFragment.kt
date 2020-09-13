package com.wpaul15.cookbook.androidApp.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wpaul15.cookbook.androidApp.R

class RecipeFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeViewModel.apply { setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        recipeViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
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