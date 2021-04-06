package com.example.expandable

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.expandable.Adapter.SubCatAdapter
import com.example.expandable.data_class.Class
import com.example.expandable.data_class.ModelClass
import com.example.expandable.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    val list: MutableList<Class> = ArrayList<Class>()
    val mainlist: MutableList<ModelClass> = ArrayList<ModelClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.btGetData?.setOnClickListener {
            var data: MutableList<String> = ArrayList()

            for (i in list.indices) {
                val value: Boolean = list.get(i).isChecked()
                if (value) {
                    data.add(list.get(i).getNamee().toString())
                }
                val p = Pattern.compile("\\[(.*?)\\]")
                val m = p.matcher(data.toString())

                while (m.find()) {
                    binding?.btSeletedText?.setText(m.group(1))
                }

            }
        }
        getChildList()

    }

    private fun getChildList() {
        val mStatus: MutableList<String> = ArrayList()
        mStatus.add("Government/Public Sector")
        mStatus.add("Civil Services")
        mStatus.add("Defence")
        mStatus.add("Business/ Self Employed")
        mStatus.add("Not Working")
        mStatus.add("Administration")

        for (i in mStatus.indices) {
            val statusModel = Class()
            statusModel.setNamee(mStatus[i])
            statusModel.setChecked(false)
            list.add(statusModel)
        }



        val title: MutableList<String> = ArrayList()
        title.add("Title One")

        for (i in title.indices) {
             val mainList = ModelClass(title[i], "1", false, list)
            mainlist.add(mainList)
        }


        val subCatAdapter = SubCatAdapter(mainlist, this)
        binding?.rvSubCat?.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )

        (binding?.rvSubCat?.getItemAnimator() as SimpleItemAnimator).supportsChangeAnimations =
            false
        binding?.rvSubCat?.setHasFixedSize(true)
        binding?.rvSubCat?.setAdapter(subCatAdapter)
    }
}


