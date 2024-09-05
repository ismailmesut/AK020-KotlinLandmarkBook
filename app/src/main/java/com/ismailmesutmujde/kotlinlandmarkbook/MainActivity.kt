package com.ismailmesutmujde.kotlinlandmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinlandmarkbook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivity.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        // Datas

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.londonbridge)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        // Adapter : Layout & Data

        // Mapping
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { landmark -> landmark.name })
        bindingMainActivity.listView.adapter = adapter
        bindingMainActivity.listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }
    }
}