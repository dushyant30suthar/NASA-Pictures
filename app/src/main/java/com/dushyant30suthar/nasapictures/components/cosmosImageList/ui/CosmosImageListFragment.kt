package com.dushyant30suthar.nasapictures.components.cosmosImageList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dushyant30suthar.nasapictures.base.BaseFragment
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.liveData.observeK
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.base.viewModel.getViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.CosmosImageListAdapter
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel.CosmosImageListViewModel
import com.dushyant30suthar.nasapictures.databinding.FragmentCosmosImageListBinding
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

        val cosmosImageListViewModel: CosmosImageListViewModel by getViewModel(viewModelFactory)
        this.cosmosImageListViewModel = cosmosImageListViewModel

        binding.cosmosImageListRV.adapter = cosmosImageListAdapter
        binding.cosmosImageListRV.layoutManager = LinearLayoutManager(activity)

        setUpViews()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        setObservers()

        cosmosImageListViewModel.getCosmosImageList()
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
        cosmosImageListViewModel.cosmosImageListRVLiveData.observeK(
            viewLifecycleOwner,
            this::onCosmosImageListSuccess,
            this::onCosmosImageListError,
            this::onCosmosImageListProgressChanged
        )
    }

    override fun performAction(action: CosmosImageListAction) {

    }

    private fun onCosmosImageListSuccess(cosmosImageList: List<RecyclerViewItem>) {
        cosmosImageListAdapter.setItems(cosmosImageList)
    }

    private fun onCosmosImageListError(throwable: Throwable) {

    }

    private fun onCosmosImageListProgressChanged(isInProgress: Boolean) {

    }

}