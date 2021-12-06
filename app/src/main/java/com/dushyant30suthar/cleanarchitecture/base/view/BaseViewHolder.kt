package com.dushyant30suthar.cleanarchitecture.base.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer


abstract class BaseViewHolder<T, Action>(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {


    var actionPerformer: ActionPerformer<Action>? = null

    abstract fun bind(data: T, position: Int)

    open fun performAction(action: Action) {
        this.actionPerformer?.performAction(action)
    }

    open fun startAnimation() {
    }

    open fun stopAnimation() {
    }
}