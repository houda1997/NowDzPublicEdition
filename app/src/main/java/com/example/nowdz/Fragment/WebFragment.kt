package com.example.nowdz.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.nowdz.R
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.web_view.view.*




public class WebFragment : Fragment() {
    var mywebview: WebView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(com.example.nowdz.R.layout.web_view, container, false)
        mywebview = v.findViewById(com.example.nowdz.R.id.web_view) as WebView

        if (mywebview == null) { print("mWebView is null")}
        if (mywebview!!.getSettings() == null) { print("Settings is null")}


       mywebview!!.loadUrl("https://google.com")

        // Enable Javascript

       val webSettings = mywebview!!.getSettings()
        webSettings.setJavaScriptEnabled(true)

        // Force links and redirects to open in the WebView instead of in a browser
        mywebview!!.setWebViewClient(WebViewClient())

        return v
    }
}

