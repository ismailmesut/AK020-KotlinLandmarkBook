package com.ismailmesutmujde.kotlinlandmarkbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinlandmarkbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var bindingDetailsActivity: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetailsActivity = ActivityDetailsBinding.inflate(layoutInflater)
        val view = bindingDetailsActivity.root
        setContentView(view)


    }
}