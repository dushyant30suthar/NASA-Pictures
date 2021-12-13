package com.dushyant30suthar.nasapictures.base.adapter

import android.view.ViewGroup
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder

interface ViewHolderFactory<Action> {

    fun getViewHolderFor(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, Action>
}