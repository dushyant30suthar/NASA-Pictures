package com.dushyant30suthar.nasapictures.components.cosmosImageList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.BaseFragment
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.viewModel.getViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.CosmosImageListAdapter
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel.CosmosImageListViewModel
import javax.inject.Inject


class CosmosImageListFragment : BaseFragment(), ActionPerformer<CosmosImageListAction> {

    companion object {
        private val TAG: String =
            CosmosImageListFragment::class.java.canonicalName ?: "UnknownClass"
    }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var cosmosImageListViewModel: CosmosImageListViewModel

    private val cosmosImageListAdapter: CosmosImageListAdapter by lazy { CosmosImageListAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cosmos_image_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cosmosImageListViewModel: CosmosImageListViewModel by getViewModel(viewModelFactory)
        this.cosmosImageListViewModel = cosmosImageListViewModel
        setUpViews()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /*
    * Initial setup*/
    private fun setUpViews() {
        setHasOptionsMenu(true)
    }

    private fun setObservers() {

    }

    override fun performAction(action: CosmosImageListAction) {

    }
}