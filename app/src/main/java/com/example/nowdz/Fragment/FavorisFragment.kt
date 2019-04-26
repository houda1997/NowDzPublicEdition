package com.example.nowdz.Fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nowdz.Main2Activity
import com.example.nowdz.R

class FavorisFragment : Fragment() {
    private var ontext : FavorisFragment.onTextPressed? = null
    private var linktext : TextView?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_favoris,null)
        linktext = v.findViewById(R.id.linktext)
        linktext!!.setOnClickListener{
            val intent = Intent (v.context, Main2Activity::class.java)
            activity!!.startActivity(intent)
        }
        return v
    }

    // Onattach

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        var activity = context as Activity
        ontext = activity as onTextPressed
    }
    //L'interface
    interface onTextPressed{
        fun sendFragement(int : Int)
    }}
