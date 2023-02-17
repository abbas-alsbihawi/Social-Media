package com.alsbihawi.abbas.socialmedia.data

import com.alsbihawi.abbas.socialmedia.data.domain.Post

object DataManger {
    private val postList= mutableListOf<Post>()

    val posts:List<Post>
        get() = postList.toList()
    fun  addPost(past: Post){
      postList.add(past)
    }

    fun  addPostAt(index:Int,past: Post){
        postList.add(index,past)
    }

    fun  addDeleteAt(index:Int){
        postList.removeAt(index)
    }
}