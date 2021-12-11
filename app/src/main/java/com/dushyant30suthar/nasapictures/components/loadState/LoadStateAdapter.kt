package com.dushyant30suthar.nasapictures.components.loadState

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

class LoadStateAdapter<T : BaseViewHolder<RecyclerViewItem, Action>, Action>(
    private val actionPerformer: ActionPerformer<Action>,
    private val getViewHolderFor: ((parent: ViewGroup, viewType: Int) -> T)?
) : RecyclerView.Adapter<T>() {

    private val loadStateItems = mutableListOf<RecyclerViewItem>()


    /**
     * LoadState to present in the adapter.
     *
     * Changing this property will immediately notify the Adapter to change the item it's
     * presenting.
     */
    var loadState: LoadState = LoadState.Initialized()
        set(loadState) {
            if (field != loadState) {
                loadStateItems.clear()
                loadStateItems.addAll(loadState.loadStateItems)
                //notifyItemRangeChanged(0, loadStateItems?.size ?: 0)
                notifyDataSetChanged()
                field = loadState
            }
        }


    override fun getItemCount(): Int {
        return loadStateItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return loadStateItems[position].viewType
    }


    enum class LoadStateLayoutPosition {
        TOP_OR_CENTER,
        BOTTOM
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): T {
        return try {
            getViewHolderFor?.let {
                it(parent, viewType)
            }.apply { this?.actionPerformer = this@LoadStateAdapter.actionPerformer }
                ?: getDefaultViewHolder(parent, viewType)
        } catch (exception: IllegalStateException) {
            getDefaultViewHolder(parent, viewType)
        }
    }

    private fun getDefaultViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): T {
        return DefaultViewHolder<Action>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        ) as T
    }


    override fun onBindViewHolder(
        holder: T,
        position: Int,
    ) {
        loadStateItems[position].let { holder.bind(it, position) }
    }

    fun attachLoadingStatesWithAdapter(
        adapter: RecyclerView.Adapter<T>,
        loadStateLayoutPosition: LoadStateLayoutPosition
    ): ConcatAdapter {
        return when (loadStateLayoutPosition) {
            LoadStateLayoutPosition.TOP_OR_CENTER -> ConcatAdapter(this, adapter)
            LoadStateLayoutPosition.BOTTOM -> ConcatAdapter(adapter, this)
        }
    }
}
