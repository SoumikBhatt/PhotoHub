package com.soumik.photohub.features.gallery.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.soumik.photohub.core.base.BasePagingAdapter
import com.soumik.photohub.core.utils.loadImage
import com.soumik.photohub.databinding.ItemGalleryPhotosBinding
import com.soumik.photohub.features.gallery.domain.models.PhotoListItem
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class PhotoListAdapter @Inject constructor (@ActivityContext private val context: Context) : BasePagingAdapter<PhotoListItem, ItemGalleryPhotosBinding>(
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
            root.setOnClickListener { onItemClicked?.let { it(item) } }
            context.loadImage(ivGalleryPhoto,item.urls?.small)
        }
    }

    /*
    * when any photo is clicked
    * */
    fun onItemClicked(listener: ((PhotoListItem) -> Unit)) {
        onItemClicked = listener
    }
}