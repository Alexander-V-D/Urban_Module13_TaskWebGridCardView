package com.example.urban_module13_taskwebgridcardview

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BrowserActivity : AppCompatActivity() {

    private lateinit var browserToolbar: Toolbar
    private lateinit var webPageWV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        browserToolbar = findViewById(R.id.browserToolbar)
        webPageWV = findViewById(R.id.webPageWV)

        setSupportActionBar(browserToolbar)
        title = getString(R.string.toolbar_title)

        webPageWV.webViewClient = WebViewClient()
        val data = Uri.parse(intent.getStringExtra("uri"))
        webPageWV.loadUrl(data.toString())

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