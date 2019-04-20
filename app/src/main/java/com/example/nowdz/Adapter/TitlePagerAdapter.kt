package com.example.nowdz.Adapter

import android.support.v4.view.PagerAdapter

import android.view.ViewGroup


import android.view.LayoutInflater

import android.view.View
import com.example.nowdz.R


class TitlePagerAdapter : PagerAdapter() {

    private var mItems: List<String> = ArrayList()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.fragment_accuille, container, false)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return mItems.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): String? {
        return mItems[position]
    }

    fun getColorItem(position: Int): String {
        return mItems[position]
    }

    fun addAll(items: List<String>) {
        mItems = ArrayList(items)
    }
}