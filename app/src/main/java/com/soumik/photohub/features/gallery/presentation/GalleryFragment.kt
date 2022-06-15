package com.soumik.photohub.features.gallery.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soumik.photohub.R
import com.soumik.photohub.databinding.FragmentGalleryBinding
import javax.inject.Inject

class GalleryFragment : Fragment() {

    private lateinit var mBinding : FragmentGalleryBinding
    @Inject lateinit var mViewModel: GalleryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentGalleryBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}