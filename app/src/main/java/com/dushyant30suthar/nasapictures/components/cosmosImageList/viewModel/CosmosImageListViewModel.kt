package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dushyant30suthar.nasapictures.base.liveData.Outcome
import com.dushyant30suthar.nasapictures.base.rx.applyIoToMainSchedulerOnSingle
import com.dushyant30suthar.nasapictures.base.rx.subscribeToSingle
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.base.viewModel.BaseViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.CosmosImageListErrorMapper
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.CosmosImageListRVItemsMapper
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases.GetCosmosImageListUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CosmosImageListViewModel @Inject constructor(
    private val getCosmosImageListUseCase: GetCosmosImageListUseCase,
    private val cosmosImageListRVItemsMapper: CosmosImageListRVItemsMapper,
    private val cosmosImageListErrorMapper: CosmosImageListErrorMapper,
) : BaseViewModel() {

    /*
    * Shows items in recycler view. Consisting of all types of viewHolders to be presented in the recyclerView.
    *
    * We do not store user's interacted data on this object. It's just a representation of what's showing.*/
    private val _cosmosImageListRVLiveData: MutableLiveData<Outcome<List<RecyclerViewItem>>> =
        MutableLiveData()
    val cosmosImageListRVLiveData: LiveData<Outcome<List<RecyclerViewItem>>>
        get() = _cosmosImageListRVLiveData


    /*
   * Original data we got from api. Not manipulated. In case we manipulate some data we can restore
   * to original data through the references added below.
   *
   * It would be null in case our network request doesn't get succeed. */
    private var originalCosmosImageList: List<CosmosImageModel>? = null


    /*
   * Manipulated data i.e. data which is being operated by user or being interacted with.
   *
   * If user edits name of image title and haven't saved the data yet.*/
    private val editedCosmosImageList: MutableList<CosmosImageModel> = mutableListOf()


    fun getCosmosImageList() {
        _cosmosImageListRVLiveData.value = Outcome.loading(true)
        compositeDisposable.add(
            getCosmosImageListUseCase.execute(Unit)
                .delay(2, TimeUnit.SECONDS)
                .applyIoToMainSchedulerOnSingle()
                .subscribeToSingle(this::onCosmosImageListSuccess, this::onCosmosImageListError)
        )
    }

    private fun onCosmosImageListSuccess(it: List<CosmosImageEntity>) {
        originalCosmosImageList = cosmosImageListRVItemsMapper.map(it)
        editedCosmosImageList.clear()
        editedCosmosImageList.addAll(originalCosmosImageList!!.map { it.copy() })
        _cosmosImageListRVLiveData.value = Outcome.loading(false)
        _cosmosImageListRVLiveData.value = Outcome.success(editedCosmosImageList)
    }

    private fun onCosmosImageListError(e: Throwable) {
        _cosmosImageListRVLiveData.value = Outcome.loading(false)
        _cosmosImageListRVLiveData.value = Outcome.apiError(cosmosImageListErrorMapper.map(e))
    }

}