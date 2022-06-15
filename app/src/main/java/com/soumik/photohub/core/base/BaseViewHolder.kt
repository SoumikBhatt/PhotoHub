package com.soumik.photohub.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class BaseViewHolder<out T : ViewBinding> constructor(val binding: T) : RecyclerView.ViewHolder(binding.root)