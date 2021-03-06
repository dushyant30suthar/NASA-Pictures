package com.dushyant30suthar.nasapictures.base.view

import android.view.View
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.action.BaseAction


abstract class BaseViewItem<T> {

    var baseActionPerformer: ActionPerformer<BaseAction>? = null

    abstract fun bind(data: T, baseActionPerformer: ActionPerformer<BaseAction>?)

    abstract fun getView(): View

    open fun performAction(baseAction: BaseAction) {
        this.baseActionPerformer?.performAction(baseAction)
    }
}