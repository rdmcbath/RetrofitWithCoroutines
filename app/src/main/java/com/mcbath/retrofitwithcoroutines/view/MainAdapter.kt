package com.mcbath.retrofitwithcoroutines.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mcbath.retrofitwithcoroutines.R
import com.mcbath.retrofitwithcoroutines.model.User

class MainAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.apply {
                val titleTextView: TextView = itemView.findViewById(R.id.textViewUserName)
                val emailTextView: TextView = itemView.findViewById(R.id.textViewUserEmail)
                val avatarIV: ImageView = itemView.findViewById(R.id.imageViewAvatar)
                titleTextView.text = user.name
                emailTextView.text = user.email
                Glide.with(avatarIV.context)
                    .load(user.avatar)
                    .error(R.drawable.user_icon)
                    .into(avatarIV)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}