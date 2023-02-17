package com.alsbihawi.abbas.socialmedia.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alsbihawi.abbas.socialmedia.R
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItem
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItemType
import com.alsbihawi.abbas.socialmedia.data.domain.Post
import com.alsbihawi.abbas.socialmedia.data.domain.Story
import com.alsbihawi.abbas.socialmedia.databinding.ItemNewPostBinding
import com.alsbihawi.abbas.socialmedia.databinding.ItemPostBinding
import com.alsbihawi.abbas.socialmedia.databinding.ItemStoriesListBinding
import com.alsbihawi.abbas.socialmedia.ui.home.stories.StoriesPostAdapter
import com.bumptech.glide.Glide

class HomeAdapter(private var items: List<HomeItem<Any>>, private val listener: HomeActionListener):RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when (viewType){
            TYPE_VIEW_STORIES-> StoryHomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_stories_list,parent,false))
            TYPE_VIEW_NEW_POST-> NewPostHomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_new_post,parent,false))
            TYPE_VIEW_POST-> PostHomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false))
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when(holder){
            is StoryHomeViewHolder->bindStories(holder,position)
            is NewPostHomeViewHolder->bindNewPost(holder,position)
            is PostHomeViewHolder->bindPost(holder,position)
            }
        }

    private fun bindPost(holder:PostHomeViewHolder, position: Int) {
      val list= items[position].item as Post
        holder.binding.apply {
            textUsername.text=list.username
            textDate.text=list.date
            Glide.with(this.root.context).load(list.urlImage).centerCrop().into(imagePost)
            Glide.with(this.root.context).load(list.avatar).into(userAvatar)

        }
    }

    private fun bindNewPost(holder: NewPostHomeViewHolder, position: Int) {
        holder.binding.apply {
            newPostAction.hint=items[position].item.toString()
            newPostAction.setOnClickListener { listener.addNewPost() }
        }

    }

    private fun bindStories(holder: StoryHomeViewHolder, position: Int) {
        val stories=items[position].item as List<Story>
       val adapter= StoriesPostAdapter(stories,listener)
        holder.binding.apply { recyclerStories.adapter=adapter  }
    }


//    fun setPost(newList: List<Post>){
//       val diffUtil=DiffUtil.calculateDiff(PostDiffUtil(list,newList))
//        list= newList
//        diffUtil.dispatchUpdatesTo(this)
//    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            HomeItemType.TYPE_STORIES -> TYPE_VIEW_STORIES
            HomeItemType.TYPE_NEW_POST -> TYPE_VIEW_NEW_POST
            HomeItemType.TYPE_POST -> TYPE_VIEW_POST
        }
   }

    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class PostHomeViewHolder(itemView: View) :BaseHomeViewHolder(itemView){
        val binding= ItemPostBinding.bind(itemView)
    }
    class NewPostHomeViewHolder(itemView: View) :BaseHomeViewHolder(itemView){
        val binding= ItemNewPostBinding.bind(itemView)
    }
    class StoryHomeViewHolder(itemView: View) :BaseHomeViewHolder(itemView){
        val binding= ItemStoriesListBinding.bind(itemView)
    }

    companion object{
        const val TYPE_VIEW_STORIES=1
        const val TYPE_VIEW_NEW_POST=2
        const val  TYPE_VIEW_POST=3
    }
}
