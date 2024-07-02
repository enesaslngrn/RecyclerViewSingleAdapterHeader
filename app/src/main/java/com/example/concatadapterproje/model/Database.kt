package com.example.concatadapterproje.model


object Database { // Database gibi yapıları singleton yaparız. Bu sayede uygulama boyunca yalnızca bir kez instance oluşturulur.

    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItems() : ArrayList<DataItem> {

        val totalList = arrayListOf<DataItem>()
        val itemList = (1..100).map { DataItem.Item(it, it.toString()) }
        val headerList = listOf("A", "B", "C", "D", "E").map { DataItem.Header(it) }

        val itemsPerHeader = itemList.size / headerList.size

        for ((index, header) in headerList.withIndex()) { // withIndex, döngüde her başlığın hem kendisine hem de indeksine erişmenizi sağlar.
            // Bu, her başlığın hangi sırada olduğunu bilmenize yardımcı olur.
            totalList.add(header)
            val startIndex = index * itemsPerHeader
            val endIndex = if (index == headerList.size - 1) itemList.size else (index + 1) * itemsPerHeader
            totalList.addAll(itemList.subList(startIndex, endIndex))
        }

        return totalList
    }
}