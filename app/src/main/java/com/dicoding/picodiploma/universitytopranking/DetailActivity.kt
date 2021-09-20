package com.dicoding.picodiploma.universitytopranking;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME ="extra_name";
    public static final String EXTRA_DESKRIPSI ="extra_deskripsi" ;
    public static final String EXTRA_PHOTO ="extra_photo" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView tvName = findViewById(R.id.tv_item_name);
        String nama = getIntent().getStringExtra(EXTRA_NAME);
        tvName.setText(nama);

        TextView tvDetail = findViewById(R.id.tv_item_detail);
        String deksripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        tvDetail.setText(deksripsi);

        ImageView imgPhoto = findViewById(R.id.img_item_photo);
        int logo = getIntent().getIntExtra(EXTRA_PHOTO, 1);
        imgPhoto.setImageResource(logo);

        getSupportActionBar().setTitle(nama);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
