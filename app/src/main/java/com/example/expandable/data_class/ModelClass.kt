package com.example.expandable.data_class

data class ModelClass(
    var name:String,
    var id:String,
    var expanded: Boolean = false,
    var childCat: List<Class>
)
{
    data class ChildCat(
        var name:String,
        var expanded: Boolean = false
    )
}

