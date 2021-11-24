package com.dushyant30suthar.cleanarchitecture.components.movieList.ui

import android.annotation.SuppressLint
import android.content.*
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.*
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer
import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem
import com.dushyant30suthar.cleanarchitecture.base.viewModel.getViewModel
import com.dushyant30suthar.cleanarchitecture.components.movieList.actions.MovieListAction
import com.dushyant30suthar.cleanarchitecture.components.movieList.adapter.MovieListAdapter
import com.dushyant30suthar.cleanarchitecture.components.movieList.viewModel.MovieListViewModel
import com.dushyant30suthar.cleanarchitecture.databinding.FragmentCrptoListBinding
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class MovieListFragment : Fragment(), ActionPerformer<MovieListAction> {

    companion object {
        private val TAG: String = MovieListFragment::class.java.canonicalName
    }

    private lateinit var binding: FragmentCrptoListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val movieListViewModel: MovieListViewModel by getViewModel(viewModelFactory)

    private val movieListAdapter: MovieListAdapter by lazy { MovieListAdapter(this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            binding = FragmentCrptoListBinding.inflate(inflater, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            setUpArguments()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setUpOrRestoreUIState()
        setUpSelectedFilterIndicators()
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    override fun onResume() {
        super.onResume()
        initialiseNetworkRequests()
        pagingJob = lifecycleScope.launch {
            movieListViewModel.cryptoList.collectLatest { pagingData ->
                movieListAdapter.submitData(pagingData)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        pagingJob?.cancel()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun setUpViews() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        binding.orderListRV.removeItemDecoration(orderItemDecorator)
        binding.orderListRV.addItemDecoration(orderItemDecorator)
        binding.orderListRV.adapter = movieListAdapter
        binding.orderListRV.layoutManager = LinearLayoutManager(activity)
        binding.orderListRV.itemAnimator = null

    }

    @SuppressLint("CheckResult")
    private fun setObservers() {

    }


    private var pagingJob: Job? = null

    private fun initialiseNetworkRequests() {
        movieListAdapter.addLoadStateListener { loadState ->
            movieListViewModel.onOrderScreenStateUpdated(
                movieListAdapter.itemCount == 0,
                loadState.refresh is LoadState.Loading
            )
        }
    }

    private fun onOrderStateListSuccess(orderStateList: List<RecyclerViewItem>) {
        orderStatusFilterListAdapter.setData(orderStateList)
        for ((index, value) in orderStateList.withIndex()) {
            if ((value as OrderStateFilterModel).isSelected) {
                orderStateFilterRV.scrollToPosition(index)
                break
            }
        }
    }

    private fun onError(error: Throwable) {
        Log.d("fdgdds", "sds")
    }

    private fun onProgress(state: Boolean) {
        if (state.not()) {
        }
    }

    /*
    * BaseAction implementations. */
    override fun performAction(action: MovieListAction) {
        when (action) {

            is DownloadQRCodePdfAction -> {
                downloadFileFromURL(action.pdfUrl, action.title)
            }

        }
    }
}