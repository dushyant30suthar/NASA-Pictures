package com.dushyant30suthar.nasapictures.components.loadState

import androidx.annotation.LayoutRes
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

/*
* Represents loadingState of list. And according to which different kinds of
* loading/error/emptyList*/
sealed class LoadState private constructor(
    @LayoutRes private val layout: Int?,
    private val counts: Int,
    private val _loadStateItem: RecyclerViewItem?
) {

    constructor(
        @LayoutRes layout: Int?,
        counts: Int
    ) : this(layout, counts, null)

    private constructor(loadStateItem: RecyclerViewItem) : this(null, 1, loadStateItem)

    val loadStateItems: List<RecyclerViewItem>
        get() {
            return if (_loadStateItem != null) {
                listOf(_loadStateItem)
            } else {
                loadStateLayoutWithoutData(layout, counts)
            }
        }

    private val loadStateLayoutWithoutData: (layout: Int?, counts: Int) -> List<RecyclerViewItem> =
        { layout, counts ->
            if (layout == null) {
                emptyList()
            } else {
                val loadStateItems = mutableListOf<RecyclerViewItem>()
                for (i in 1..counts) {
                    loadStateItems.add(object : RecyclerViewItem {
                        override val viewType: Int = layout
                    })
                }
                loadStateItems
            }
        }

    /*
    * Load States. */
    class Loading : LoadState {

        /*
        * */
        constructor(@LayoutRes layout: Int?, counts: Int? = null) : super(layout, counts ?: 1)

        /*
        * If you are providing Data then you should also be providing viewHolder
        * for the same. Like in your viewHolder Factory or just return it through
        * implemented method.*/
        constructor(_loadStateItem: RecyclerViewItem) : super(_loadStateItem)
    }

    sealed class Success {

        class Empty : LoadState {

            /*
        * If you are providing Data then you should also be providing viewHolder
        * for the same. Like in your viewHolder Factory or just return it through
        * implemented method.*/
            constructor(loadStateItems: RecyclerViewItem) : super(loadStateItems)

            constructor() : super(null, 0)
        }

        class HasItems : LoadState(null, 0)
    }

    class Error : LoadState {

        constructor(@LayoutRes layout: Int, counts: Int? = null) : super(layout, counts ?: 1)

        constructor() : super(null, 0)

        /*
    * If you are providing Data then you should also be providing viewHolder
    * for the same. Like in your viewHolder Factory or just return it through
    * implemented method.*/
        constructor(loadStateItems: RecyclerViewItem) : super(loadStateItems)
    }

    class Initialized : LoadState {
        constructor(@LayoutRes layout: Int, counts: Int? = null) : super(layout, counts ?: 1)

        constructor() : super(null, 0)
    }
}