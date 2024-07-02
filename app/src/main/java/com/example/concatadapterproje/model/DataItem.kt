package com.example.concatadapterproje.model

sealed class DataItem { // sealed class olarak tanımlamak, sadece belirli alt sınıfların kullanılmasına olanak sağlar. BAsitçe tür güvenliği artar.

    data class Item(val id : Int, val text : String) : DataItem()
    data class Header(val text : String) : DataItem()

}