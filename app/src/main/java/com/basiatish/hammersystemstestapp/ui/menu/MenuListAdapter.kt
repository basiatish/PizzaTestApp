package com.basiatish.hammersystemstestapp.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.basiatish.domain.entities.MenuItem
import com.basiatish.hammersystemstestapp.R
import com.basiatish.hammersystemstestapp.databinding.MenuListItemBinding
import com.basiatish.hammersystemstestapp.utils.GlideApp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MenuListAdapter : ListAdapter<MenuItem, MenuListAdapter.ViewHolder>(DiffCallBack) {

    inner class ViewHolder(private val binding: MenuListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: MenuItem, context: Context) {
            binding.title.text = menu.title
            binding.helperText.text = menu.description
            binding.button.text = context.resources.getString(R.string.price, menu.price)
            loadLogo(menu.photoUrl)
        }

        private fun loadLogo(url: String) {
            val storage = Firebase.storage
            val photoRef = storage.reference.child(url)
            GlideApp.with(binding.pizzaLogo).load(photoRef)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .skipMemoryCache(true)
                .error(R.drawable.test2)
                .fitCenter()
                .circleCrop()
                .into(binding.pizzaLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MenuListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, holder.itemView.context)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.description == newItem.description
        }

    }
}