package com.ismailmesutmujde.kotlinlandmarkbook.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismailmesutmujde.kotlinlandmarkbook.R
import com.ismailmesutmujde.kotlinlandmarkbook.adapter.LandmarkAdapter
import com.ismailmesutmujde.kotlinlandmarkbook.databinding.ActivityMainBinding
import com.ismailmesutmujde.kotlinlandmarkbook.model.Landmark


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

        // Inefficient (Verimsiz)
        // val pisaBitmap = BitmapFactory.decodeResource(resources, R.drawable.pisa)


        // RECYCLER VIEW
        bindingMainActivity.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        bindingMainActivity.recyclerView.adapter = landmarkAdapter

        /*
        // LISTVIEW KULLANIMI

        // Adapter : Layout & Data

        // Mapping

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { landmark -> landmark.name })
        bindingMainActivity.listView.adapter = adapter
        bindingMainActivity.listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }

        */
    }
}