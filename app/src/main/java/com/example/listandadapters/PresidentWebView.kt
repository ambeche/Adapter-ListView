package com.example.listandadapters

import android.content.Intent.EXTRA_TEXT
import android.content.Intent.EXTRA_TITLE
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_president_web_view.*

class PresidentWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_president_web_view)

        val url = intent.extras?.getString(EXTRA_TEXT)
        val title = intent.extras?.getString(EXTRA_TITLE)

        webView.webViewClient = WebViewClient()

        if (url != null) {
            setTitle(title)
            webView.loadUrl(url)
            Log.d("url", url)
        }
    }
}