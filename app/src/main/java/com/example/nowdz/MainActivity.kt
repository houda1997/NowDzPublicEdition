package com.example.nowdz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar


class MainActivity : AppCompatActivity() {

    private var topToolbar :Toolbar? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()


    }

    /**
     * Preparer le toolbar
     */
    private fun setToolbar(){
        topToolbar = findViewById(R.id.toolbar_accuille)
        setSupportActionBar(topToolbar)
    }
}
