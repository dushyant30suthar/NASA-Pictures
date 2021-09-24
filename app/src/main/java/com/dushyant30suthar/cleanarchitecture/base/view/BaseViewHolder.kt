package com.dushyant30suthar.cleanarchitecture.base.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer


abstract class BaseViewHolder<T, Actions>(itemView: View) : RecyclerView.ViewHolder(itemView) {


    var actionPerformer: ActionPerformer<Actions>? = null

    abstract fun bind(data: T, position: Int)

    open fun performAction(action: Actions) {
        this.actionPerformer?.performAction(action)
    }

    open fun startAnimation() {
    }

    open fun stopAnimation() {
    }
}