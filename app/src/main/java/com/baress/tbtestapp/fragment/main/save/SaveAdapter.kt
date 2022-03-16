package com.baress.tbtestapp.fragment.main.save

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.baress.tbtestapp.R
import com.baress.tbtestapp.databinding.ItemListViewBinding
import com.baress.tbtestapp.domain.model.NetworkEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class SaveAdapter : RecyclerView.Adapter<SaveAdapter.SaveHolder>() {
    private lateinit var itemListViewBinding: ItemListViewBinding
    private var list = ArrayList<NetworkEntity>()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveHolder {
        itemListViewBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_view, parent, false)
        return SaveHolder(itemListViewBinding)
    }

    override fun onBindViewHolder(holder: SaveHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setListItem(items: List<NetworkEntity>) {
        list.addAll(items)
    }

    inner class SaveHolder(private val binding: ItemListViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NetworkEntity) {
            val reviewCount = if (item.reviewCount > 300) "300+" else item.reviewCount.toString()
            Glide.with(binding.root.context)
                .load(item.thumbnail)
                .transform(CenterCrop(), RoundedCorners(12))
                .into(binding.thumbnail)
            binding.classificationText.text = item.classification
            binding.restaurantNameText.text = item.restaurantName
            binding.reviewText.text = "${item.rating} ($reviewCount)"
            binding.summaryAddressText.text = item.summaryAddress

            binding.useWaitingText.isVisible = item.useWaiting
            binding.remoteWaitingButton.isVisible = item.isRemoteWaiting
        }
    }
}
