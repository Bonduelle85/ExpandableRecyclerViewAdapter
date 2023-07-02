package com.example.expandablerecyclerviewadapter

data class Item(
    val id: Long,
    val name: String,
    val company: String,
    val subItems: List<String> = mutableListOf(),
    var isExpanded:Boolean = false
)