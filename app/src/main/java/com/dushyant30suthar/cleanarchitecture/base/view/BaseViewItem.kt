package com.dushyant30suthar.cleanarchitecture.base.view

import android.view.View
import com.dushyant30suthar.cleanarchitecture.base.action.Action
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer


abstract class BaseViewItem<T> {

    var actionPerformer: ActionPerformer<Action>? = null

    abstract fun bind(data: T, actionPerformer: ActionPerformer<Action>?)

    abstract fun getView(): View

    open fun performAction(action: Action) {
        this.actionPerformer?.performAction(action)
    }
}