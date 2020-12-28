package com.ayros.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var url: EditText
    lateinit var search: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById<WebView>(R.id.webView).apply{
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl("http:/www.yandex.ru")
        }

        url = findViewById(R.id.editURL)
        search = findViewById<ImageButton>(R.id.searchButton)
        search.setOnClickListener {
                webView.loadUrl("http:/www.${url.text}")
            }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}