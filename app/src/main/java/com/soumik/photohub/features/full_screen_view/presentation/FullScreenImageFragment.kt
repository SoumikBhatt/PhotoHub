package com.soumik.photohub.features.full_screen_view.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soumik.photohub.R

class FullScreenImageFragment : Fragment() {

    companion object {
        fun newInstance() = FullScreenImageFragment()
    }

    private lateinit var viewModel: FullScreenImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_full_screen_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FullScreenImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}