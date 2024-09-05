package com.ismailmesutmujde.kotlinlandmarkbook.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinlandmarkbook.databinding.ActivityDetailsBinding
import com.ismailmesutmujde.kotlinlandmarkbook.model.Landmark

class DetailsActivity : AppCompatActivity() {

    private lateinit var bindingDetailsActivity: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetailsActivity = ActivityDetailsBinding.inflate(layoutInflater)
        val view = bindingDetailsActivity.root
        setContentView(view)


        val intent = intent

        // casting
        val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark
        bindingDetailsActivity.nameText.text = selectedLandmark.name
        bindingDetailsActivity.countryText.text = selectedLandmark.country
        bindingDetailsActivity.imageView.setImageResource(selectedLandmark.image)
    }
}