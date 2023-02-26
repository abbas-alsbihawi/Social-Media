package com.alsbihawi.abbas.socialmedia.ui.search

import android.view.LayoutInflater
import com.alsbihawi.abbas.socialmedia.databinding.FragmentSearchBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseFragment
import java.io.File

class SearchFragment:BaseFragment<FragmentSearchBinding>() {
    override val LOG_TAG: String = SearchFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding  = FragmentSearchBinding::inflate

    override fun setUp() {
        binding?.saveFile?.setOnClickListener {
            val text=binding?.inputNameFile?.text.toString()
            saveTextToFile(text)
        }
    }

    private fun saveTextToFile(text: String) {
        val path =context?.applicationInfo?.dataDir
        val fileName="sample.txt"
        val file=File("$path/$fileName")
        file.appendText(text)
    }
}