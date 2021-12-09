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
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.MovieListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.MovieListAdapter
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel.MovieListViewModel
import javax.inject.Inject


class MovieListFragment : BaseFragment(), ActionPerformer<MovieListAction> {

    companion object {
        private val TAG: String = MovieListFragment::class.java.canonicalName
    }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val movieListViewModel: MovieListViewModel by getViewModel(viewModelFactory)

    private val movieListAdapter: MovieListAdapter by lazy { MovieListAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
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

    private fun setUpViews() {
        setHasOptionsMenu(true)

    }

    private fun setObservers() {

    }

    override fun performAction(action: MovieListAction) {

    }
}