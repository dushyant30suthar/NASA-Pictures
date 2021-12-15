package com.dushyant30suthar.nasapictures.components.cosmosImageDetails.viewModel

import androidx.lifecycle.LiveData
import com.dushyant30suthar.nasapictures.base.liveData.Outcome
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

interface CosmosImageDetailsViewModel {

    val cosmosImageListRVLiveData: LiveData<Outcome<List<RecyclerViewItem>>>

    fun getCosmosImageList()

}