package com.soumik.photohub.core.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.isGone() = this.visibility == View.GONE

fun View.handleVisibility(value: Boolean) {
    if (value) this.visible()
    else this.gone()
}

fun Fragment.showSnackBar(
    binding: ViewBinding,
    message: String,
    length: Int = Snackbar.LENGTH_SHORT
) {
    if (isAdded)
        Snackbar.make(binding.root, message, length).show()
}