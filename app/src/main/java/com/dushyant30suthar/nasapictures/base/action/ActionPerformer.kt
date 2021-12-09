package com.dushyant30suthar.nasapictures.base.action

interface ActionPerformer<ACTION> {
    fun performAction(action: ACTION)
}