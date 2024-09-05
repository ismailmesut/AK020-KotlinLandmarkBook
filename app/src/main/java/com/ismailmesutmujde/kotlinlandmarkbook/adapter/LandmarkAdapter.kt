package com.ismailmesutmujde.kotlinlandmarkbook.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismailmesutmujde.kotlinlandmarkbook.databinding.RecyclerRowBinding
import com.ismailmesutmujde.kotlinlandmarkbook.model.Landmark
import com.ismailmesutmujde.kotlinlandmarkbook.view.DetailsActivity

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {
    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    // recycler_row' u bağlama işlemi burada yapılır.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    // bağlama işlemi yapıldıktan sonra yapılacak işlemler burada yapılır.
    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    // recycler_row'dan kaç tane oluşturulacaksa burada yapılır.
    override fun getItemCount(): Int {
        return landmarkList.size
    }


}