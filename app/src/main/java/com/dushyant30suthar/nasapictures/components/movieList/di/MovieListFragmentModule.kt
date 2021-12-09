package com.dushyant30suthar.nasapictures.components.movieList.di

import androidx.lifecycle.ViewModel
import com.dushyant30suthar.nasapictures.components.movieList.viewModel.MovieListViewModel
import com.dushyant30suthar.nasapictures.configuration.dagger.annotations.ViewModelKey
import com.dushyant30suthar.nasapictures.configuration.dagger.scopes.PerFragment
import com.dushyant30suthar.nasapictures.data.movie.services.MovieService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(
    includes = [MovieListFragmentModule.MovieListFragmentProviderModule::class]
)

abstract class MovieListFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    @PerFragment
    abstract fun bindMovieListViewModel(movieListViewModel: MovieListViewModel): ViewModel


    @Module
    object MovieListFragmentProviderModule {


        @Provides
        @PerFragment
        internal fun bindMovieService(retrofit: Retrofit): MovieService {
            return retrofit.create(
                MovieService
                ::class.java
            )
        }

    }
}
