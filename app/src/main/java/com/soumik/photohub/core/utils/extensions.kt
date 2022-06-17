package com.soumik.photohub.core.utils

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.soumik.photohub.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

fun Context.share(
    subject: String? = "Checkout this Image",
    body: String? = "",
    chooserTitle: String? = "Share via"
) {
    try {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "$body"
        )
        startActivity(Intent.createChooser(shareIntent, chooserTitle))
    } catch (e: Exception) {
    }
}

/** executing a task asynchronously
 * on IO thread, and then returning the result in
 * MAIN thread
 * @param   onPreExecute    task to execute before the async task
 * @param   doInBackground  task to be executed in background
 * @param   onPostExecute   returning the result from the AsyncTask*/
fun <R,T> CoroutineScope.executeAsyncTask(
    params : T,
    onPreExecute: () -> Unit,
    doInBackground: (T) -> R,
    onPostExecute: (R) -> Unit
) {
    launch {
        onPreExecute()
        val result = withContext(Dispatchers.IO) {
            doInBackground(params)
        }
        onPostExecute(result)
    }
}