package com.soumik.photohub.core.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.soumik.photohub.R
import com.soumik.photohub.databinding.BtmSheetPhotoInfoBinding

/**
created by Soumik on 7/7/22.
soumik.nybsys@gmail.com
Copyright (c) 2022 NybSys. All rights reserved
 **/

fun Context.showPhotoInfoBottomSheet(
    description: String?,
    altDescription: String?,
    location: String?,
    name: String?,
    likes: Int?
) {
    val (binding, dialog) = createDialog(BtmSheetPhotoInfoBinding.inflate(LayoutInflater.from(this)))

    binding.apply {
        if (!description.isNullOrEmpty()) tvPhotoDesc.text = description else tvPhotoDesc.gone()
        if (likes!=null) tvPhotoLikes.text = likes.toString() else tvPhotoLikes.gone()
        if (!altDescription.isNullOrEmpty()) tvPhotoAltDesc.text = altDescription else tvPhotoAltDesc.gone()
        if (!location.isNullOrEmpty()) tvPhotoLocation.text = location else tvPhotoLocation.gone()
        if (!name.isNullOrEmpty()) tvPhotographerName.text = name else tvPhotographerName.gone()
    }

    dialog.show()
}

private fun <V:ViewBinding> Context.createDialog(viewBinding: V): Pair<V, BottomSheetDialog> {
    val dialog = BottomSheetDialog(this,R.style.BottomSheetDialog).apply {
        setCancelable(true)
        setContentView(viewBinding.root)
        create()
    }
    return Pair(viewBinding, dialog)
}