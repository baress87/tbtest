package com.baress.tbtestapp.fragment.main.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.baress.tbtestapp.R
import com.baress.tbtestapp.databinding.ItemListViewBinding
import com.baress.tbtestapp.domain.model.NetworkEntity
import com.bumptech.glide.Glide

class RecentAdapter : RecyclerView.Adapter<RecentAdapter.RecentHolder>() {
    private lateinit var itemListViewBinding: ItemListViewBinding
    private var list = ArrayList<NetworkEntity>()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentHolder {
        itemListViewBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_view, parent, false)
        return RecentHolder(itemListViewBinding)
    }

    override fun onBindViewHolder(holder: RecentHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setListItem(items: List<NetworkEntity>) {
        list.addAll(items)
    }

    inner class RecentHolder(private val binding: ItemListViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NetworkEntity) {
            Glide.with(binding.root.context).load(item.thumbnail).into(binding.thumbnail)
            binding.classificationText.text = item.classification
            binding.restaurantNameText.text = item.restaurantName
            binding.reviewText.text = "${item.rating} (${item.reviewCount})"
            binding.summaryAddressText.text = item.summaryAddress

            binding.useWaitingText.isVisible = item.useWaiting
            binding.remoteWaitingButton.isVisible = item.isRemoteWaiting
        }
    }
}
