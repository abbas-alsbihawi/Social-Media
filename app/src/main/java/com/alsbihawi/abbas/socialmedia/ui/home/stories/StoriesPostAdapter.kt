package com.alsbihawi.abbas.socialmedia.ui.home.stories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alsbihawi.abbas.socialmedia.R
import com.alsbihawi.abbas.socialmedia.data.domain.Story
import com.alsbihawi.abbas.socialmedia.databinding.ItemAddStoryBinding
import com.alsbihawi.abbas.socialmedia.databinding.ItemStoryBinding
import com.alsbihawi.abbas.socialmedia.ui.home.HomeActionListener
import com.bumptech.glide.Glide

class StoriesPostAdapter(private var list: List<Story>, private val listener: HomeActionListener):RecyclerView.Adapter<StoriesPostAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            TYPE_VIEW_ADD  -> AddViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_add_story,parent,false))
            TYPE_VIEW_STORY  -> StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_story,parent,false))
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun getItemCount()=list.size+1

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is StoryViewHolder->bindStory(holder,position)
            is AddViewHolder->bindAdd(holder,position)
        }
    }

    private fun bindAdd(holder: AddViewHolder, position: Int) {
        holder.binding.apply {
           if (position==0) imageAddStory.setOnClickListener {listener.addNewStory(it) }
        }
    }

    private fun bindStory(holder: StoryViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(this.root.context)
                .load(list[position-1].urlImage)
                .into(imageStory)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return  if (position==0)  TYPE_VIEW_ADD else  TYPE_VIEW_STORY
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class StoryViewHolder(itemView: View) :BaseViewHolder(itemView){
        val binding= ItemStoryBinding.bind(itemView)
    }
    class AddViewHolder(itemView: View) :BaseViewHolder(itemView){
        val binding= ItemAddStoryBinding.bind(itemView)
    }

    companion object{
        const val TYPE_VIEW_ADD=1
        const val TYPE_VIEW_STORY=2

    }
}
