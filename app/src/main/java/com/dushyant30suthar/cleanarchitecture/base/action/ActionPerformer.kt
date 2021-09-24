package com.dushyant30suthar.cleanarchitecture.base.action

interface ActionPerformer<ACTION> {
    fun performAction(action: ACTION)
}