package com.alsbihawi.abbas.socialmedia.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItem

class HomeDiffUtil(private val pOldList: List<HomeItem<Any>>, private val pNewList: List<HomeItem<Any>>,):DiffUtil.Callback() {
    override fun getOldListSize()=pOldList.size

    override fun getNewListSize()=pNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return  true
//        (

//               pOldList[oldItemPosition].username==pNewList[newItemPosition].username
//                       && pOldList[oldItemPosition].details==pNewList[newItemPosition].details
//               )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return true
    }
}