package com.natife.example.project1.models

data class Item(
    val id: Int,
    val name: String = "name $id",
    val description: String = "description $id"
)