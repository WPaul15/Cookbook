package com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AbstractViewAdapterImpl<in T>(
    items: MutableList<T>,
    layoutResId: Int,
    private val bindHolder: View.(T) -> Unit
) : AbstractViewAdapter<T>(items, layoutResId) {

    override fun View.bind(item: T) {
        bindHolder(item)
    }
}

fun <T> RecyclerView.init(
    items: MutableList<T>,
    layoutResId: Int,
    bindHolder: View.(T) -> Unit,
    manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
): AbstractViewAdapterImpl<T> {
    setHasFixedSize(true)
    addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
    return AbstractViewAdapterImpl(items, layoutResId) { bindHolder(it) }.apply {
        layoutManager = manager
        adapter = this
    }
}
