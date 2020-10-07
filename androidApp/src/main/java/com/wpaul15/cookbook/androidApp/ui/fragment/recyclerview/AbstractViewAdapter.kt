package com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewAdapter<in T>(
    private var items: MutableList<T>,
    private val layoutResId: Int
) : RecyclerView.Adapter<AbstractViewAdapter.ViewHolder>() {

    protected abstract fun View.bind(position: Int, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.bind(position, items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
