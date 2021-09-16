package com.dicoding.picodiploma.universitytopranking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dicoding.picodiploma.universitytopranking.adapter.ListUniversityAdapter;
import com.dicoding.picodiploma.universitytopranking.model.About;
import com.dicoding.picodiploma.universitytopranking.model.University;
import com.dicoding.picodiploma.universitytopranking.model.UniversityData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUniversity;
    private ArrayList<University> list = new ArrayList<>();

    private void showSelectedUniversity(University university) {
        Toast.makeText(this, "Kamu memilih " + university.getName(), Toast.LENGTH_SHORT).show();
        Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveIntent.putExtra(DetailActivity.EXTRA_NAME, R.id.tv_item_name);
        moveIntent.putExtra(DetailActivity.EXTRA_DESKRIPSI, R.id.tv_item_detail);
        moveIntent.putExtra(DetailActivity.EXTRA_PHOTO, R.id.img_item_photo);
        startActivity(moveIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("University Top Ranking");

        rvUniversity = findViewById(R.id.rv_university);
        rvUniversity.setHasFixedSize(true);

        list.addAll(UniversityData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvUniversity.setLayoutManager(new LinearLayoutManager(this));
        ListUniversityAdapter listUniversityAdapter = new ListUniversityAdapter(list);
        rvUniversity.setAdapter(listUniversityAdapter);

        listUniversityAdapter.setOnItemClickCallback(new ListUniversityAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(University data) {
                showSelectedUniversity(data);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
         if(id == R.id.about){
             Intent move_intent = new Intent(MainActivity.this, About.class);
             startActivity(move_intent);
             return true;
         }
         return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
