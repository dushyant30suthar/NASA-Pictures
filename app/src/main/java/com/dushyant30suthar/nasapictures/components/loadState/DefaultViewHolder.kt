package com.dushyant30suthar.nasapictures.components.loadState


import androidx.databinding.ViewDataBinding
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

/*
* When you just provide layout not any ViewHolder then loadStateAdapter
* crates ViewHolder for you.*/
class DefaultViewHolder<Action>(
    private val binding: ViewDataBinding,
) : BaseViewHolder<RecyclerViewItem, Action>(binding.root) {


    override fun bind(
        data: RecyclerViewItem,
        position: Int,
    ) {

        binding.executePendingBindings()
    }

}