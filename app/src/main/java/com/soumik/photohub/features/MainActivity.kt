package com.soumik.photohub.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soumik.photohub.R
import com.soumik.photohub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)
    }
}