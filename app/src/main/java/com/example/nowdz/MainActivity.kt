package com.example.nowdz

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.support.v7.widget.PopupMenu
import android.util.Log
import android.widget.Toast
import android.content.Intent
import android.net.Uri
import android.support.design.widget.NavigationView
import com.example.nowdz.Adapter.NewAdapter
import com.example.nowdz.Fragment.*
import android.view.Menu
import android.view.MenuItem
import com.example.nowdz.Fragment.AcuilleFragment
import com.example.nowdz.Fragment.FavorisFragment
import com.example.nowdz.Fragment.TitreFragement
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_news_secondaire.*



class MainActivity : BaseActivity(),FavorisFragment.onTextPressed,AcuilleFragment.onWebView {


    override fun showWebView() {
        //web_view!!.loadUrl("https://www.elwatan.com")
        chargerFagment(WebFragment())
    }

    override fun sendFragement(int: Int) {
        when(int){
            1->{
                chargerFagment(EnregistreFragment())
            }
        }
    }
    private var topToolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chargerFagment(AcuilleFragment())
        setToolbar()
        navigation()



    }

    /**
     * Preparer le toolbar
     */
    private fun setToolbar() {
        topToolbar = findViewById(R.id.toolbar_accuille)
        setSupportActionBar(topToolbar)
    }

    /**
     * la navigation par le navigation bottom entre les fragement
     */
    private fun navigation() {
        navigation_bar.setOnNavigationItemSelectedListener {
            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.item_accuille -> {
                    fragment = AcuilleFragment()
             }
                R.id.item_favoris -> {

                    fragment = FavorisFragment()

                }
                R.id.item_titre -> {
                    fragment = TitreFragement()
                }
            }
            return@setOnNavigationItemSelectedListener chargerFagment(fragment)
        }
    }

    /**
     * le changement de fragement
     */
    @SuppressLint("CommitTransaction")
    private fun chargerFagment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_id, fragment).commit()
            return true
        }
        return false
    }
    /**
     * Preparer l'historique

    private fun setSavedActivity() {
        val intent = Intent (this, Main2Activity::class.java)
        startActivity(intent)
    }
     */

    /**
     *  Le menu popup
     */

    private fun popsurf ()
    {
        card2_menu.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_popup_save -> {
                        Toast.makeText(this, "Showing Save Toast!", Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.menu_popup_share -> {
                        Toast.makeText(this, "Showing Share Toast!", Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.menu_popup_access -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resocoder.com"))
                        startActivity(intent)
                        true
                    }
                    R.id.menu_popup_hide -> {
                        Toast.makeText(this, "Showing Hide Toast!", Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> false
                }
            }


        popupMenu.inflate(R.menu.menu_popup)



        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMPopup.isAccessible = true
            val mPopup = fieldMPopup.get(popupMenu)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        } catch (e: Exception){
            Log.e("Main", "Error showing menu icons.", e)
        } finally {
            popupMenu.show()
        }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.settings)
            startActivity(Intent(this, SettingsActivity::class.java))

        return super.onOptionsItemSelected(item)
    }
}
