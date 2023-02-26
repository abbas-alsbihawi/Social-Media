package com.alsbihawi.abbas.socialmedia.util

import android.content.Context
import android.content.SharedPreferences

object PrefUtil {
    private  var sharedPreferences:SharedPreferences?=null
    const val SHARED_PREF_NAME="sharedPrefName"
    const val KEY_USERNAME="username"
   fun initPrefUtil (context: Context){
        sharedPreferences=  context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }
    var username:String?
    get() = sharedPreferences?.getString(KEY_USERNAME,null)
    set(value) {
     sharedPreferences?.edit()
         ?.putString(KEY_USERNAME,value)
         ?.apply()
    }
}