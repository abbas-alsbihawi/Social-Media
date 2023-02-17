package com.alsbihawi.abbas.socialmedia.util

import com.alsbihawi.abbas.socialmedia.data.domain.HomeItem
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItemType
import com.alsbihawi.abbas.socialmedia.data.domain.Post

fun Post.toHomeItem():HomeItem<Any>{
    return HomeItem(this,HomeItemType.TYPE_POST)
}