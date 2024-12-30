package com.example.urban_module13_taskwebgridcardview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainToolbar: Toolbar
    private lateinit var cardsGV: GridView

    private val list = listOf(
        GridViewModal("Яндекс", R.drawable.yandex, "https://ya.ru"),
        GridViewModal("Gismeteo", R.drawable.gismeteo, "https://www.gismeteo.ru"),
        GridViewModal("Google", R.drawable.google, "https://www.google.ru")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainToolbar = findViewById(R.id.mainToolbar)
        cardsGV = findViewById(R.id.cardsGV)

        setSupportActionBar(mainToolbar)
        title = getString(R.string.toolbar_title)

        val adapter = GridViewAdapter(list, this)
        cardsGV.adapter = adapter

        cardsGV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val intent = Intent(this, BrowserActivity::class.java)
                intent.putExtra("uri", list[position].uri)
                startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.toolbarExitBTN -> finishAffinity()
        }
        return true
    }
}