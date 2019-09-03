package com.autentia.demo.databiding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.autentia.demo.databiding.CustomRecyclerViewAdapter.CustomViewHolder
import com.google.android.material.button.MaterialButton

class CustomRecyclerViewAdapter(private val posts: MutableList<Post>) :
    Adapter<CustomViewHolder>() {

    fun setData(data: MutableList<Post>) {
        posts.clear()
        posts.addAll(data)
        notifyDataSetChanged()
    }

    fun removePost(post: Post) {
        val index = posts.indexOf(post)
        if (index != -1) {
            posts.remove(post)
            notifyItemRemoved(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.post_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    inner class CustomViewHolder(view: View) : ViewHolder(view) {

        fun bind(post: Post) {
            itemView.findViewById<TextView>(R.id.title_post_value).text = post.title
            itemView.findViewById<TextView>(R.id.body_post_value).text = post.body
            itemView.findViewById<MaterialButton>(R.id.remove_post_button).setOnClickListener {
                removePost(post)
            }
        }
    }
}
