package com.dicoding.picodiploma.universitytopranking.model;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.universitytopranking.R;

public class About extends AppCompatActivity {

    public static final String EXTRA_NAME_USER = "extra_name_user";
    public static final String EXTRA_PHOTO_USER = "extra_photo_user";
    public static final String EXTRA_EMAIL = "extra_email";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("About");

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
