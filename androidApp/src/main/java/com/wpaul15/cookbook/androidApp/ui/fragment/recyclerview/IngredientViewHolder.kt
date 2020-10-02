package com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview

import com.wpaul15.cookbook.androidApp.R
import com.wpaul15.cookbook.shared.Ingredient
import kotlinx.android.synthetic.main.view_holder_ingredient.view.*

class IngredientViewHolder(items: MutableList<Ingredient>) :
	AbstractViewAdapter<Ingredient>(items) {

	override fun bind(item: Ingredient, holder: ViewHolder) {
		holder.itemView.text_ingredient.text = "$item"
	}

	override fun getItemViewType(position: Int): Int {
		return R.layout.view_holder_ingredient
	}
}

//fun <ITEM> RecyclerView.init(
//	items: MutableList<ITEM>,
//	layoutResId: Int,
//	bindHolder: View.(ITEM) -> Unit,
//	viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
//): IngredientViewHolder<ITEM> {
//	layoutManager = viewManager
//	return IngredientViewHolder(items, layoutResId, bindHolder).apply {
//		adapter = this
//	}
//}
