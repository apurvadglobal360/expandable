package com.example.expandable.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expandable.R
import com.example.expandable.data_class.ModelClass

class SubCatAdapter(private var mDataList: List<ModelClass>? = mutableListOf(), var context: Context): RecyclerView.Adapter<SubCatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCatAdapter.ViewHolder {
        return SubCatAdapter.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cab_cat, parent, false))
    }

    override fun onBindViewHolder(holder: SubCatAdapter.ViewHolder, position: Int) {
        val holderData=mDataList?.get(position)
        holder.titleTextView.setText(holderData?.name)


        if (holderData?.childCat?.isNullOrEmpty() == false) {
            holder.rvChildCat.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val subCatAdapter = ChilCatAdapter(holderData.childCat, context)
            holder.rvChildCat.adapter = subCatAdapter
            val isExpanded: Boolean = mDataList?.get(position)!!.expanded
            holder.expandableLayout.setVisibility(if (isExpanded) View.VISIBLE else View.GONE)
     //       Glide.with(context).load(R.drawable.minus).into(holder.imgAdd)
        }


        holder.titleTextView.setOnClickListener {
            if (holderData?.childCat?.isNullOrEmpty() == false) {
                val movie: ModelClass = mDataList?.get(holder.adapterPosition)!!

                if (!movie.expanded) {
                    movie.expanded = true

                    Glide.with(context).load(R.drawable.minus).into(holder.imgAdd)

                } else {
                    movie.expanded = false
                    Glide.with(context).load(R.drawable.ic_plus).into(holder.imgAdd)
                }
                notifyItemChanged(holder.adapterPosition)

            }else{
      //
            }
        }
    }

    override fun getItemCount(): Int {
        return if (mDataList?.isNotEmpty() == true) mDataList?.size ?: 0 else 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvChildCat: RecyclerView
        var titleTextView: TextView
        var expandableLayout: ConstraintLayout
        var imgAdd:ImageView
        var imgLogo:ImageView

        init {
            rvChildCat = itemView.findViewById(R.id.rvChildCat)
            titleTextView = itemView.findViewById(R.id.titleTextView)
            expandableLayout=itemView.findViewById(R.id.expandableLayout)
            imgAdd=itemView.findViewById(R.id.imgAdd)
            imgLogo=itemView.findViewById(R.id.imgLogo)

        }
    }
}