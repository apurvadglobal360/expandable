package com.example.expandable.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expandable.R
import com.example.expandable.data_class.Class

class ChilCatAdapter(
    private var mDataList: List<Class>? = mutableListOf(),
    var context: Context
) : RecyclerView.Adapter<ChilCatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChilCatAdapter.ViewHolder {
        return ChilCatAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.child_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChilCatAdapter.ViewHolder, position: Int) {
        val holderData=mDataList?.get(position)
        holder.txtCatName.setText(holderData?.name)


        holder.checkBox.setOnCheckedChangeListener(null)
        holder.checkBox.isChecked = mDataList?.get(position)?.isChecked() == true

        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked -> /*         if (isChecked){
                        getItemList.addCountry(model.getName());
                    }else {
                        getItemList.removePlayer(model.getName());
                    }*/
            mDataList?.get(holder.adapterPosition)?.setChecked(isChecked)
        }
    }

    override fun getItemCount(): Int {
        return if (mDataList?.isNotEmpty() == true) mDataList?.size ?: 0 else 0
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCatName: TextView
        var checkBox: CheckBox

        init {
            txtCatName = itemView.findViewById(R.id.txtString)
            checkBox = itemView.findViewById(R.id.checkBox)
        }
    }
}