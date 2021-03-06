package com.dushyant30suthar.nasapictures.components.cosmosImageList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.BaseFragment
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.liveData.observeK
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageDetails.ui.CosmosImageDetailsFragment.Companion.IMAGE_ID
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageSelectedAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.CosmosImageListAdapter
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.CosmosImageListViewHolderFactory
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel.CosmosImageListViewModel
import com.dushyant30suthar.nasapictures.components.loadState.LoadState
import com.dushyant30suthar.nasapictures.components.loadState.LoadStateAdapter
import com.dushyant30suthar.nasapictures.databinding.FragmentCosmosImageListBinding
import javax.inject.Inject


class CosmosImageListFragment : BaseFragment(), ActionPerformer<CosmosImageListAction> {

    companion object {
        private val TAG: String =
            CosmosImageListFragment::class.java.canonicalName ?: "UnknownClass"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val cosmosImageListViewModel: CosmosImageListViewModel by navGraphViewModels(R.id.navigation_cosmos) { viewModelFactory }

    private val cosmosImageListViewHolderFactory = CosmosImageListViewHolderFactory()

    private val cosmosImageListAdapter: CosmosImageListAdapter by lazy {
        CosmosImageListAdapter(
            this,
            cosmosImageListViewHolderFactory
        )
    }

    private val cosmosImageListLoadStateAdapter by lazy {
        LoadStateAdapter(
            this,
            cosmosImageListViewHolderFactory
        )
    }

    private val concatenatedCosmosImageListAndLoadStateAdapter: ConcatAdapter by lazy {
        cosmosImageListLoadStateAdapter.attachLoadingStatesWithAdapter(
            cosmosImageListAdapter,
            LoadStateAdapter.LoadStateLayoutPosition.TOP_OR_CENTER
        )
    }

    private lateinit var binding: FragmentCosmosImageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCosmosImageListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        cosmosImageListViewModel.getCosmosImageList()
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
        setHasOptionsMenu(false)
        cosmosImageListAdapter.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding.cosmosImageListRV.adapter = concatenatedCosmosImageListAndLoadStateAdapter
        binding.cosmosImageListRV.layoutManager = GridLayoutManager(activity, 2)
    }

    private fun setObservers() {
        cosmosImageListViewModel.cosmosImageListRVLiveData.observeK(
            viewLifecycleOwner,
            this::onCosmosImageListSuccess,
            this::onCosmosImageListError,
            this::onCosmosImageListProgressChanged
        )
    }

    override fun performAction(action: CosmosImageListAction) {
        when (action) {
            is CosmosImageSelectedAction -> {
                findNavController().navigate(
                    R.id.action_cosmosImageListFragment_to_cosmosImageDetailsFragment,
                    Bundle().apply {
                        putInt(IMAGE_ID, action.imageId)
                    })
            }
        }
    }

    private fun onCosmosImageListSuccess(cosmosImageList: List<RecyclerViewItem>) {
        cosmosImageListLoadStateAdapter.loadState = LoadState.Success.HasItems()
        cosmosImageListAdapter.setItems(cosmosImageList)
        concatenatedCosmosImageListAndLoadStateAdapter.notifyDataSetChanged()
    }

    private fun onCosmosImageListError(errorItem: RecyclerViewItem?) {
        if (errorItem != null) {
            /*
            * Known Error. */
            cosmosImageListLoadStateAdapter.loadState =
                LoadState.Error(errorItem)
        } else {
            /*
            * Unknown Error.*/
            cosmosImageListLoadStateAdapter.loadState =
                LoadState.Error(R.layout.layout_error_cosmos_image_list)
        }
    }

    private fun onCosmosImageListProgressChanged(isInProgress: Boolean) {
        if (isInProgress) {
            cosmosImageListLoadStateAdapter.loadState =
                LoadState.Loading(R.layout.item_loading_cosmos_image, 16)
        }
    }

}