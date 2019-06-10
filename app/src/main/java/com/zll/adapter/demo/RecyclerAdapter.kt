package com.zll.adapter.demo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daimler.popeye.base.CommonViewHolder

/**
 * Created on 2019/5/13
 * Author: zhangll
 * Email: 413700858@qq.com
 */
abstract class RecyclerAdapter<T>: RecyclerView.Adapter<CommonViewHolder>() {

    abstract fun createView(parent: ViewGroup, viewType: Int): View
    abstract fun View.bindView(data: T, position: Int)

    var onScrollToBottom = {  }

    protected var data = mutableListOf<T>()

    override fun getItemCount() = data.size

    fun getItem(position: Int) = data[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolder(createView(parent, viewType))
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.contentView.bindView(data[position], position)
        if (position == itemCount - 1)
            onScrollToBottom.invoke()
    }

    open fun refreshAll(data: MutableList<T>) {
        this.data = data
        notifyDataSetChanged()
    }
}