package com.alsbihawi.abbas.socialmedia.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.alsbihawi.abbas.socialmedia.databinding.FragmentProfileBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseFragment
import com.alsbihawi.abbas.socialmedia.util.Constants

class ProfileFragment:BaseFragment<FragmentProfileBinding>() {
    override val LOG_TAG: String=ProfileFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentProfileBinding=FragmentProfileBinding::inflate
    override fun setUp() {
        setUsername()
        binding?.apply {
            buttonSave.setOnClickListener {
                saveUsername()
                Toast.makeText(context,inputName.text.toString(),Toast.LENGTH_SHORT).show()
                setUsername()
            }
        }
    }

    private fun setUsername() {
        val sharedPreferences=  requireActivity().getSharedPreferences(Constants.SHARED_PREF_NAME,Context.MODE_PRIVATE)

        binding?.textUsername?.text=sharedPreferences.getString(Constants.USERNAME,"")
    }

    private fun saveUsername() {
      val sharedPreferences=  requireActivity().getSharedPreferences(Constants.SHARED_PREF_NAME,Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val name=binding?.inputName?.text.toString()
        editor.putString(Constants.USERNAME,name)
        editor.apply()
    }
}