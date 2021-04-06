package com.example.expandable.data_class

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FilterCarModelVariant {

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("desc")
    @Expose
    private var desc: String? = null

    @SerializedName("code")
    @Expose
    private var code: String? = null

    @SerializedName("Status")
    @Expose
    private var Status: String? = null

    var isChecked: Boolean = false


    fun getNamee(): String? {
        return name
    }

    fun setNamee(name: String?) {
        this.name = name
    }


    fun getdesc(): String? {
        return desc
    }

    fun setdesc(desc: String?) {
        this.desc = desc
    }


    fun getcode(): String? {
        return code
    }

    fun setcode(code: String?) {
        this.code = code
    }


    fun getStatus(): String? {
        return Status
    }

    fun setStatus(Status: String?) {
        this.Status = Status
    }


    fun isChecKed(): Boolean {
        return isChecked
    }

    fun setChecKed(checked: Boolean) {
        isChecked = checked
    }

}