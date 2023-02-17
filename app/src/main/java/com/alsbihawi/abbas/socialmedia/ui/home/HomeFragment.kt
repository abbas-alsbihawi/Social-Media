package com.alsbihawi.abbas.socialmedia.ui.home

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.alsbihawi.abbas.socialmedia.data.DataSource
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItem
import com.alsbihawi.abbas.socialmedia.data.domain.HomeItemType
import com.alsbihawi.abbas.socialmedia.databinding.FragmentHomeBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseFragment
import com.alsbihawi.abbas.socialmedia.util.toHomeItem
import com.google.android.material.snackbar.Snackbar

class HomeFragment : BaseFragment<FragmentHomeBinding>(),HomeActionListener {

    override val LOG_TAG: String=HomeFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =FragmentHomeBinding::inflate
    private lateinit var  adapter :HomeAdapter

    override fun setUp() {
        val itemsList:MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(HomeItem(DataSource.getStories(),HomeItemType.TYPE_STORIES))
        itemsList.add(HomeItem("Update Your status",HomeItemType.TYPE_NEW_POST))
        itemsList.addAll(DataSource.getPosts().map { it.toHomeItem() } )
        adapter= HomeAdapter(itemsList,this)
        binding?.apply { recyclerHome.adapter=adapter }
    }

    override fun addNewStory(view: View) {
        Snackbar.make(view,"ADD Story", Snackbar.LENGTH_SHORT).show()
    }

    override fun addNewPost() {
        Toast.makeText(context,"ADD Story", Toast.LENGTH_SHORT).show()
    }

}