package com.alsbihawi.abbas.socialmedia.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.alsbihawi.abbas.socialmedia.databinding.FragmentProfileBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseFragment
import com.alsbihawi.abbas.socialmedia.util.Constants
import com.alsbihawi.abbas.socialmedia.util.PrefUtil.initPrefUtil
import com.alsbihawi.abbas.socialmedia.util.PrefUtil.username

class ProfileFragment:BaseFragment<FragmentProfileBinding>() {
    override val LOG_TAG: String=ProfileFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentProfileBinding=FragmentProfileBinding::inflate
    override fun setUp() {
        initPrefUtil(requireActivity())
        loadingUsername()
        binding?.apply {
            buttonSave.setOnClickListener {
                saveUsername()
                Toast.makeText(context,inputName.text.toString(),Toast.LENGTH_SHORT).show()
                loadingUsername()
            }
        }
    }

    private fun loadingUsername() {
        binding?.textUsername?.text=username
    }

    private fun saveUsername() {
        username=binding?.inputName?.text.toString()
    }
}