package com.example.expandable.data_class

class Class() {
    var name: String? = null
    private var isChecked = false

    fun getNamee(): String? {
        return name
    }

    fun setNamee(name: String?) {
        this.name = name
    }


    fun isChecked(): Boolean {
        return isChecked
    }

    fun setChecked(checked: Boolean) {
        isChecked = checked
    }
}