package com.soumik.photohub.features.gallery.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.soumik.photohub.core.base.BasePagingAdapter
import com.soumik.photohub.databinding.ItemGalleryPhotosBinding
import com.soumik.photohub.features.gallery.domain.models.PhotoListItem
import com.squareup.picasso.Picasso

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class PhotoListAdapter : BasePagingAdapter<PhotoListItem, ItemGalleryPhotosBinding>(
    diffCallback = object : DiffUtil.ItemCallback<PhotoListItem>() {
        override fun areItemsTheSame(oldItem: PhotoListItem, newItem: PhotoListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PhotoListItem, newItem: PhotoListItem): Boolean {
            return oldItem==newItem
        }

    }
) {

    private var onItemClicked: ((PhotoListItem) -> Unit) ? = null

    override fun createBinding(parent: ViewGroup): ItemGalleryPhotosBinding {
        return ItemGalleryPhotosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    }

    override fun bind(binding: ItemGalleryPhotosBinding, item: PhotoListItem, position: Int) {
        binding.apply {
            Picasso.get().load(item.urls?.small).into(ivGalleryPhoto)
            root.setOnClickListener { onItemClicked?.let { it(item) } }
        }
    }

    /*
    * when any photo is clicked
    * */
    fun onItemClicked(listener: ((PhotoListItem) -> Unit)) {
        onItemClicked = listener
    }
}