package com.dushyant30suthar.cleanarchitecture.base.view

import androidx.annotation.Keep

@Keep
interface RecyclerViewItem {
    val viewType: Int
}