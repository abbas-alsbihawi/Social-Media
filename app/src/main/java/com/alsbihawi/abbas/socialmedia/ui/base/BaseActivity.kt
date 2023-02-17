package com.alsbihawi.abbas.socialmedia.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alsbihawi.abbas.socialmedia.R

abstract class BaseActivity<VB: ViewBinding>:AppCompatActivity() {

    abstract val LOG_TAG:String
    abstract val bindingInflater:(LayoutInflater)->VB
    private var _binding:ViewBinding?=null
    protected var binding: VB? = null
        get() =  _binding as VB?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        addCallBacks()
        setUp()

    }

    abstract  fun setUp()

    abstract fun addCallBacks()

    protected fun log(value:Any){
        Log.v(LOG_TAG,value.toString())
    }
}