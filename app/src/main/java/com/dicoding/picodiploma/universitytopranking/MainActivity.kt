package com.dicoding.picodiploma.universitytopranking

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.universitytopranking.model.University
import android.widget.Toast
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.dicoding.picodiploma.universitytopranking.model.UniversityData
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.universitytopranking.adapter.ListUniversityAdapter
import com.dicoding.picodiploma.universitytopranking.adapter.ListUniversityAdapter.OnItemClickCallback
import com.dicoding.picodiploma.universitytopranking.model.About
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var rvUniversity: RecyclerView

    private val list = ArrayList<University>()
    private fun showSelectedUniversity(university: University) {
        Toast.makeText(this, "Kamu memilih " + university.name, Toast.LENGTH_SHORT).show()
        val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveIntent.putExtra(DetailActivity.EXTRA_NAME, R.id.tv_item_name)
        moveIntent.putExtra(DetailActivity.EXTRA_DESKRIPSI, R.id.tv_item_detail)
        moveIntent.putExtra(DetailActivity.EXTRA_PHOTO, R.id.img_item_photo)
        startActivity(moveIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "University Top Ranking"
        rvUniversity = findViewById(R.id.rv_university)
        rvUniversity.setHasFixedSize(true)
        list.addAll(UniversityData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvUniversity.layoutManager = LinearLayoutManager(this)
        val listUniversityAdapter = ListUniversityAdapter(list)
        rvUniversity.adapter = listUniversityAdapter
        listUniversityAdapter.onItemClickCallback =
            object : OnItemClickCallback {
                override fun onItemClicked(data: University?) {
                    data?.let { showSelectedUniversity(it) }
                }
            }
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        if (id == R.id.about) {
            val move_intent = Intent(this@MainActivity, About::class.java)
            startActivity(move_intent)
            return true
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}