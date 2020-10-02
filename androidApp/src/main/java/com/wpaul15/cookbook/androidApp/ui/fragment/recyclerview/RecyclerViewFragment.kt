package com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wpaul15.cookbook.androidApp.databinding.FragmentRecyclerViewBinding
import com.wpaul15.cookbook.shared.Ingredient

class RecyclerViewFragment : Fragment() {

	private var _binding: FragmentRecyclerViewBinding? = null
	private val binding get() = _binding!!

	private lateinit var recyclerView: RecyclerView
	private lateinit var viewAdapter: RecyclerView.Adapter<*>
	private lateinit var viewManager: RecyclerView.LayoutManager

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val items = arguments?.getParcelableArrayList<Ingredient>(KEY_ITEMS_LIST)?.toMutableList()!!

		viewManager = LinearLayoutManager(view.context)
		viewAdapter = IngredientViewHolder(items)

		recyclerView = binding.recyclerViewList.apply {
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

		const val KEY_ITEMS_LIST: String = "com.wpaul15.cookbook.ITEMS_LIST"

		fun newInstance(items: MutableList<Ingredient>) = RecyclerViewFragment().apply {
			arguments = Bundle().apply {
				putParcelableArrayList(KEY_ITEMS_LIST, ArrayList<Parcelable>(items))
			}
		}

//		const val KEY_ITEMS_LIST: String = "com.wpaul15.cookbook.ITEMS_LIST"
//		const val KEY_LAYOUT_RES_ID: String = "com.wpaul15.cookbook.LAYOUT_RES_ID"
//		const val KEY_BIND_HOLDER: String = "com.wpaul15.cookbook.BIND_HOLDER"
//
//		fun <ITEM : Parcelable> newInstance(
//			items: MutableList<ITEM>,
//			layoutResId: Int,
//			bindHolder: View.(ITEM) -> Unit
//		) =
//			RecyclerViewFragment<ITEM>().apply {
//				arguments = Bundle().apply {
//					putParcelableArrayList(KEY_ITEMS_LIST, ArrayList<Parcelable>(items))
//					putInt(KEY_LAYOUT_RES_ID, layoutResId)
//					putSerializable(KEY_BIND_HOLDER, bindHolder as Serializable)
//				}
//			}
	}
}
