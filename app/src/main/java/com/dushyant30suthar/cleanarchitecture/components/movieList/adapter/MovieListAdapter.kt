package com.dushyant30suthar.cleanarchitecture.components.movieList.adapter

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dukaan.app.order.list.actions.OrderListAction
import com.dukaan.app.order.list.model.OrderListItemModel
import com.dukaan.app.order.list.model.TableOrderListItemModel
import com.dukaan.app.order.list.ui.OrderListViewHolderFactory
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer
import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem


class MovieListAdapter(private val actionPerformer: ActionPerformer<OrderListAction>?) :
    PagingDataAdapter<RecyclerViewItem, BaseViewHolder<RecyclerViewItem, OrderListAction>>(
        OrderComparator()
    ) {

    private val recyclerViewPool = RecyclerView.RecycledViewPool()
    private val viewHolderFactory: OrderListViewHolderFactory =
        OrderListViewHolderFactory(recyclerViewPool)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<RecyclerViewItem, OrderListAction> {
        return (viewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, OrderListAction>).apply {
            actionPerformer = this@MovieListAdapter.actionPerformer
        }
    }


    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewType ?: 0
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<RecyclerViewItem, OrderListAction>,
        position: Int,
    ) {
        val orderListItem = getItem(position)
        if (orderListItem != null) {
            holder.bind(orderListItem, position)
        } else {
            Log.e("OrderListAdapter", "getItem returned null")
        }
    }


    class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView, state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    //top = spaceHeight
                } else {
                    top = spaceHeight
                }
                //left =  spaceHeight
                //right = spaceHeight
                bottom = spaceHeight
            }
        }
    }

    class OrderComparator : DiffUtil.ItemCallback<RecyclerViewItem>() {
        override fun areItemsTheSame(
            oldItem: RecyclerViewItem,
            newItem: RecyclerViewItem
        ): Boolean {
            // Id is unique.
            return if (oldItem is OrderListItemModel || newItem is OrderListItemModel) {
                (oldItem as OrderListItemModel).order.orderId?.equals((newItem as OrderListItemModel).order.orderId)
            } else {
                (oldItem as TableOrderListItemModel).order.orderId?.equals((newItem as TableOrderListItemModel).order.orderId)
            }
        }

        override fun areContentsTheSame(
            oldItem: RecyclerViewItem,
            newItem: RecyclerViewItem
        ): Boolean {
            return if (oldItem is OrderListItemModel || newItem is OrderListItemModel) {
                (oldItem as OrderListItemModel) == (newItem as OrderListItemModel)
            } else {
                (oldItem as TableOrderListItemModel) == (newItem as TableOrderListItemModel)
            }
        }
    }

}