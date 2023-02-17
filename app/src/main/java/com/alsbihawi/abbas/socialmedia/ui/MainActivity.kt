package com.alsbihawi.abbas.socialmedia.ui


import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.alsbihawi.abbas.socialmedia.R
import com.alsbihawi.abbas.socialmedia.databinding.ActivityMainBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseActivity
import com.alsbihawi.abbas.socialmedia.ui.home.HomeFragment


class MainActivity : BaseActivity<ActivityMainBinding>(){
    override val LOG_TAG: String  = "MAIN_ACTIVITY"//MainActivity::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding  = ActivityMainBinding::inflate

    override fun setUp() {
        val transaction=  supportFragmentManager.beginTransaction()
        binding?.fragmentContainer?.id?.let { transaction.add(it,HomeFragment()) }
        transaction.commit()
    }

    override fun addCallBacks() {
        binding?.bottomNavigationView?.setOnItemSelectedListener{ item ->


            when(item.itemId){
                R.id.action_home->{
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.action_favorite->{
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.action_search->{
                    replaceFragment(HomeFragment())
                    true
                }
                else -> false
            }
        }
    }
        private fun replaceFragment(fragment: Fragment) {
        val transaction=  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
  }

}