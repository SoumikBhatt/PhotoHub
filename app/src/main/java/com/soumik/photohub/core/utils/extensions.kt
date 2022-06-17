package com.soumik.photohub.core.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.soumik.photohub.R
import com.squareup.picasso.Picasso

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

fun Context.loadImage(view: ImageView, url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(this)
    circularProgressDrawable.apply {
        strokeWidth = 5f
        centerRadius = 30f
        setColorSchemeColors(
            ContextCompat.getColor(this@loadImage, R.color.black_200)
        )
        start()
    }

    Picasso
        .get()
        .load(url)
        .fit()
        .centerInside()
        .placeholder(circularProgressDrawable)
        .into(view)
}