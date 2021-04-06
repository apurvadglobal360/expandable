package com.example.expandable

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.expandable.Adapter.ChilCatAdapter
import com.example.expandable.Adapter.SubCatAdapter
import com.example.expandable.data_class.Class
import com.example.expandable.data_class.FilterCarModelVariant
import com.example.expandable.data_class.ModelClass
import com.example.expandable.databinding.ActivityMainBinding
import com.example.expandable.network.Api
import com.example.expandable.network.ApiClints
import com.google.gson.Gson
import com.msgp.data.network.model.GetFilterResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.regex.Pattern

class MainActivity : ChilCatAdapter.AddName,ChilCatAdapter.removeNamee,AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val api: Api = ApiClints.getClient()!!.create(Api::class.java)
    val list: MutableList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.btGetData?.setOnClickListener {
            var data: MutableList<String> = ArrayList()


            for (i in list.indices) {
             /*   val value: Boolean = list.get(i).isChecKed()
                if (value) {
                    data.add(list.get(i).getNamee().toString())
                }*/
                val p = Pattern.compile("\\[(.*?)\\]")
                val m = p.matcher(list.toString())

                while (m.find()) {
                    binding?.btSeletedText?.setText(m.group(1))
                    Log.d("TAG", "add_name: "+m.group(1))
                }

            }
        }
        getChildList()

    }

    private fun getChildList() {
  /*      val mStatus: MutableList<String> = ArrayList()
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
*/

       /* val subCatAdapter = SubCatAdapter(mainlist, this)
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
        binding?.rvSubCat?.setAdapter(subCatAdapter)*/



        api.getData()?.subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

                ?.subscribe(object : io.reactivex.rxjava3.core.SingleObserver<GetFilterResponse?> {
                    override fun onSubscribe(d: io.reactivex.rxjava3.disposables.Disposable?) {

                    }

                    override fun onSuccess(value: GetFilterResponse?) {
                        binding?.rvSubCat?.setLayoutManager(LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false))
                        val subCatAdapter = SubCatAdapter(value?.result?.modelCar, this@MainActivity)
                        (binding?.rvSubCat?.getItemAnimator() as SimpleItemAnimator).supportsChangeAnimations = false
                        binding?.rvSubCat?.setHasFixedSize(true)
                        binding?.rvSubCat?.setAdapter(subCatAdapter)
                    }

                    override fun onError(e: Throwable?) {

                    }

                })


    }

    override fun add_name(name: String) {
        list.add(name)
        Log.d("TAG", "add_name: "+name)

    }

    override fun removee_name(name: String) {
        Log.d("TAG", "remove: "+name)
        list.remove(name)

    }
}



