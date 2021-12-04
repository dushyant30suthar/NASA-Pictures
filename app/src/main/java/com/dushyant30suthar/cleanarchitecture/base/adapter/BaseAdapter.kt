package com.dushyant30suthar.cleanarchitecture.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dushyant30suthar.cleanarchitecture.base.action.BaseAction
import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem


abstract class BaseAdapter :
    RecyclerView.Adapter<BaseViewHolder<RecyclerViewItem, BaseAction>>() {

    private val itemList = mutableListOf<RecyclerViewItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, BaseAction> {
        return getViewHolder(parent, viewType)
    }

    abstract fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, BaseAction>

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return itemList[position].viewType
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<RecyclerViewItem, BaseAction>,
        position: Int
    ) {
        holder.bind(itemList[position], position)
    }

    fun updateItems(updatedItems: List<RecyclerViewItem>?) {
        val startingPosition = itemList.size
        if (!updatedItems.isNullOrEmpty()) {
            itemList.addAll(updatedItems)
            notifyItemRangeInserted(startingPosition, updatedItems.size)
        }
    }

    fun addItem(item: RecyclerViewItem, position: Int) {
        itemList.add(position, item)
        notifyItemInserted(position)
    }

    fun setItems(list: List<RecyclerViewItem>) {
        this.itemList.clear()
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<RecyclerViewItem, BaseAction>) {
        super.onViewAttachedToWindow(holder)
        holder.startAnimation()
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<RecyclerViewItem, BaseAction>) {
        super.onViewDetachedFromWindow(holder)
        holder.stopAnimation()
    }

}