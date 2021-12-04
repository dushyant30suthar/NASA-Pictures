package com.dushyant30suthar.cleanarchitecture.components.movieList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dushyant30suthar.cleanarchitecture.base.BaseFragment
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer
import com.dushyant30suthar.cleanarchitecture.base.viewModel.getViewModel
import com.dushyant30suthar.cleanarchitecture.components.movieList.actions.MovieListAction
import com.dushyant30suthar.cleanarchitecture.components.movieList.adapter.MovieListAdapter
import com.dushyant30suthar.cleanarchitecture.components.movieList.viewModel.MovieListViewModel
import com.dushyant30suthar.cleanarchitecture.databinding.FragmentMovieListBinding
import javax.inject.Inject


class MovieListFragment : BaseFragment(), ActionPerformer<MovieListAction> {

    companion object {
        private val TAG: String = MovieListFragment::class.java.canonicalName
    }

    private lateinit var binding: FragmentMovieListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val movieListViewModel: MovieListViewModel by getViewModel(viewModelFactory)

    private val movieListAdapter: MovieListAdapter by lazy { MovieListAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
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