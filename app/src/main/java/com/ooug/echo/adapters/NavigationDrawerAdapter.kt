package com.ooug.echo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ooug.echo.R
import com.ooug.echo.activites.MainActivity
import com.ooug.echo.fragments.AboutUsFragment
import com.ooug.echo.fragments.FavoriteFragment
import com.ooug.echo.fragments.MainScreenFragment
import com.ooug.echo.fragments.SettingsFragment


class NavigationDrawerAdapter(_contentList: ArrayList<String>,_getImages: IntArray,_context: Context)
    : RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>(){
    var contentList: ArrayList<String>?=null
    var getImages: IntArray?=null
    var mContext: Context?=null

    init {
        this.contentList = _contentList
        this.getImages = _getImages
        this.mContext = _context
    }
    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
        holder?.icon_GET?.setBackgroundResource(getImages?.get(position) as Int)
        holder?.text_GET?.setText(contentList?.get(position))
        holder?.content_Holder?.setOnClickListener({
            if (position == 0){
                val mainScreenFragment = MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, mainScreenFragment)
                        .commit()
            }else if(position == 1){
                val favoriteFragment = FavoriteFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, favoriteFragment)
                        .commit()
            }else if(position == 2){
                val settingsFragment = SettingsFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, settingsFragment)
                        .commit()
            }else{
                val aboutusFragment = AboutUsFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, aboutusFragment)
                        .commit()
            }
            MainActivity.Statified.drawerLayout?.closeDrawers()
        })
    }

    override fun getItemCount(): Int {
        return (contentList as ArrayList).size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {

        var itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_navigationdrawer,parent,false)
        val returnThis = NavViewHolder(itemView)
        return returnThis

    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var icon_GET: ImageView?=null
        var text_GET:TextView?=null
        var content_Holder:RelativeLayout?=null
        init {
            icon_GET = itemView?.findViewById(R.id.icon_navdrawer)
            text_GET = itemView?.findViewById(R.id.text_navdrawer)
            content_Holder = itemView?.findViewById(R.id.nav_drawer_content_holder)
        }
    }

}