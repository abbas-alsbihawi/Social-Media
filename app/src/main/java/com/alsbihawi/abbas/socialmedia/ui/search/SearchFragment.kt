package com.alsbihawi.abbas.socialmedia.ui.search

import android.Manifest
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Environment
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.alsbihawi.abbas.socialmedia.databinding.FragmentSearchBinding
import com.alsbihawi.abbas.socialmedia.ui.base.BaseFragment
import java.io.File

class SearchFragment:BaseFragment<FragmentSearchBinding>() {

     var requestPermissionLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission()){isGranted->
        if (isGranted){

        }else{

        }
    }
    override val LOG_TAG: String = SearchFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding  = FragmentSearchBinding::inflate

    override fun setUp() {
        binding?.saveFile?.setOnClickListener {
            val text=binding?.inputNameFile?.text.toString()
            if (ContextCompat.checkSelfPermission(context?.applicationContext!!, Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED) {
                saveTextToFile(text)
            }
            else{
                requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }

        }
    }

    private fun saveTextToFile(text: String) {
//        val path =context?.getExternalFilesDir(null)?.path.toString()
//        val path = Environment.getExternalStorageDirectory().path.toString()
        val path =  ContextWrapper(context?.applicationContext).getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)?.path
        val fileName="sample.txt"
        val file=File("$path/$fileName")
        file.appendText(text).apply {
            Toast.makeText(context,"Teat",Toast.LENGTH_SHORT).show()
        }
    }
}