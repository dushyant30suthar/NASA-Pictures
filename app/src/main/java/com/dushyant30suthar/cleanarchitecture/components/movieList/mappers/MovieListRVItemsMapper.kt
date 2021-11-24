package com.dushyant30suthar.cleanarchitecture.components.movieList.mappers

import com.dushyant30suthar.cleanarchitecture.base.mapper.Mapper
import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem
import javax.inject.Inject

class MovieListRVItemsMapper @Inject constructor() :
    Mapper<Any?, RecyclerViewItem> {


    fun map(srcObject: Any?): List<RecyclerViewItem> {
        return mutableListOf()
    }


}