package com.dicoding.picodiploma.universitytopranking.adapter;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.universitytopranking.DetailActivity;
import com.dicoding.picodiploma.universitytopranking.R;
import com.dicoding.picodiploma.universitytopranking.model.University;

import java.util.ArrayList;

public class ListUniversityAdapter extends RecyclerView.Adapter<ListUniversityAdapter.ListViewHolder> {
    private ArrayList<University> listUniversity;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListUniversityAdapter(ArrayList<University> list) {
        this.listUniversity = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_university, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final University university = listUniversity.get(position);

        Glide.with(holder.itemView.getContext())
                .load(university.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(university.getName());
        holder.tvDetails.setText(university.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PHOTO, university.getPhoto());
                intent.putExtra(DetailActivity.EXTRA_NAME, university.getName());
                intent.putExtra(DetailActivity.EXTRA_DESKRIPSI, university.getDetail());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUniversity.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetails;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetails = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public OnItemClickCallback getOnItemClickCallback() {
        return onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(University data);
    }
}
