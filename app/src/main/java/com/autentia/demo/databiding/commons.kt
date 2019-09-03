package com.autentia.demo.databiding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, data: MutableList<Post>?) {
    val adapter = recyclerView?.adapter
    if (adapter is CustomRecyclerViewAdapter && data != null) {
        adapter.setData(data)
    }
}
