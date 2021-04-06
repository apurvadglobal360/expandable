package com.msgp.data.network.model

import android.os.Parcelable
import com.example.expandable.data_class.FilterCarModelVariant
import com.example.expandable.network.BaseResponseModel
import com.google.gson.annotations.SerializedName


data class GetFilterResponse(
    @SerializedName("result")
    var result: GetFilterResult
) : BaseResponseModel()


data class GetFilterResult(
    @SerializedName("parentCategories")
    val parentCategories: ArrayList<FilterParentCategory>,
    @SerializedName("modelcar")
    val modelCar: ArrayList<FilterCarModel>
)


data class FilterParentCategory(
    @SerializedName("name")
    val name: String,
    @SerializedName("Id")
    val Id: String,
    @SerializedName("Status")
    val Status: String?,
    @SerializedName("categories")
    val categories: MutableList<FilterCategory>
)


data class FilterCategory(
    @SerializedName("name")
    val name: String,
    @SerializedName("CatgType")
    val CatgType: String,
    @SerializedName("Status")
    val Status: String?,
    @SerializedName("subcategories")
    val subcategories: MutableList<FilterSubCategory>
)

data class FilterSubCategory(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("type")
    val type: String?,
    @SerializedName("Code")
    val Code: String,

    var isChecked: Boolean = false
)


data class FilterCarModel(
        @SerializedName("name")
    val name: String,
        @SerializedName("desc")
    val desc: String,
        @SerializedName("StartDate")
    val StartDate: String,
        @SerializedName("EndDate")
    val EndDate: String,
        @SerializedName("Code")
    val Code: String,
        @SerializedName("Status")
    val Status: String,
        @SerializedName("varients")
    val varients: List<FilterCarModelVariant>,

        var isChecked: Boolean = false
)


/*
data class FilterCarModelVariant(
    @SerializedName("name")
    val name: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("Status")
    val Status: String,

    var isChecked: Boolean = false

)*/
