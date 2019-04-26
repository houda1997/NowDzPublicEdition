package com.example.nowdz.Fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast
import com.example.nowdz.Adapter.NewAdapter
import com.example.nowdz.R


class AcuilleFragment : Fragment() {
    private val newsList = ArrayList<String>()
    private var newsRecyclerView: RecyclerView? = null
    private var newsAdapter: NewAdapter? = null
    private var webView : onWebView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_accuille,null)
        initRvNews(v)
        ajouterNews()
        var popup : ImageView = v.findViewById(R.id.card1_menu)
        val popupMenu = PopupMenu(this!!.context!!,v)
        popup!!.setOnClickListener {
            /***/
                item ->
            when (item.id) {
                R.id.menu_popup_save -> {
                    Toast.makeText(context, "Showing Save Toast!", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.menu_popup_share -> {
                    val shareintent = Intent(Intent.ACTION_SEND)
                    shareintent.type = "type/palin"
                    val sharebody = "The body"
                    val sharesub = "The subject"
                    shareintent.putExtra(Intent.EXTRA_SUBJECT, sharebody)
                    shareintent.putExtra(Intent.EXTRA_TEXT, sharesub)
                    ContextCompat.startActivity(this!!.context!!,Intent.createChooser(shareintent, "Share article"),Bundle())



                    Toast.makeText(context, "Showing Share Toast!", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.menu_popup_access -> {
                    Toast.makeText(context, "Showing access Toast!", Toast.LENGTH_SHORT).show()

                    Log.i("isClicked", "log success")
                    if (webView == null) {
                        Log.i("webView", "null web")
                    } else {
                        Log.i("webView", "not null web")
                        webView!!.showWebView()
                    }
                    true
                }
                R.id.menu_popup_hide -> {
                    Toast.makeText(context, "Showing Hide Toast!", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }



          popupMenu.inflate(R.menu.menu_popup)

            try {
                val fieldMPopup = popupMenu!!::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(mPopup, true)
            } catch (e: Exception) {
                Log.e("Main", "Error showing menu icons.", e)
            } finally {
                popupMenu.show()
            }
        }
            /***/


        return v

    }

    private fun initRvNews(v: View){
        newsRecyclerView = v.findViewById(R.id.recycle_news_acuille)
        newsAdapter = NewAdapter(newsList,v.context,v,webView)

        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsRecyclerView!!.layoutManager = horizontalLayoutManager
        newsRecyclerView!!.adapter = newsAdapter
    }
    private fun ajouterNews(){
        newsList.add("a")
        newsList.add("a")
        newsList.add("a")
        newsList.add("a")
        newsAdapter!!.notifyDataSetChanged()
    }

    // Onattach

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        var activity = context as Activity
        webView = activity as onWebView
    }
    //L'interface
    interface onWebView{
        fun showWebView()
    }

}

