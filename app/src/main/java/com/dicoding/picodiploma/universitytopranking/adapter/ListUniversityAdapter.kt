package com.dicoding.picodiploma.universitytopranking.adapter

import com.dicoding.picodiploma.universitytopranking.model.University
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.universitytopranking.adapter.ListUniversityAdapter.ListViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.dicoding.picodiploma.universitytopranking.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.dicoding.picodiploma.universitytopranking.DetailActivity
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.widget.TextView
import java.util.ArrayList

class ListUniversityAdapter(private val listUniversity: ArrayList<University>) : RecyclerView.Adapter<ListViewHolder>() {
    var onItemClickCallback: OnItemClickCallback? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_university, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val university = listUniversity[position]

        Glide.with(holder.itemView.context)
            .load(university.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = university.name
        holder.tvDetails.text = university.detail

        holder.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PHOTO, university.photo)
            intent.putExtra(DetailActivity.EXTRA_NAME, university.name)
            intent.putExtra(DetailActivity.EXTRA_DESKRIPSI, university.detail)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listUniversity.size
    }

    inner class ListViewHolder(itemView: View) : ViewHolder(itemView) {
        var imgPhoto: ImageView
        var tvName: TextView
        var tvDetails: TextView

        init {
            imgPhoto = itemView.findViewById(R.id.img_item_photo)
            tvName = itemView.findViewById(R.id.tv_item_name)
            tvDetails = itemView.findViewById(R.id.tv_item_detail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: University?)
    }
}