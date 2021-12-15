package com.dushyant30suthar.nasapictures.components.cosmosImageList.actions

import com.dushyant30suthar.nasapictures.base.action.BaseAction

interface CosmosImageListAction : BaseAction

class CosmosImageSelectedAction(val imageId: Int) : CosmosImageListAction
