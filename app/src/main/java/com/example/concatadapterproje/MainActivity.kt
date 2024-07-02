package com.example.concatadapterproje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterproje.databinding.ActivityMainBinding
import com.example.concatadapterproje.model.Database
import com.shuhart.stickyheader.StickyHeaderItemDecorator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalList = Database.getItems()
        val adapter = RecyclerAdapter(totalList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        /* Direkt attack edince duplicate oluyor.
        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(binding.recyclerView)

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            var isStickyHeaderAttached = false
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val firstVisibleItemPosition = (binding.recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                // Check -> Eğer decorator hali hazırda attach edildiyse

                if (!isStickyHeaderAttached && firstVisibleItemPosition > 0){
                    val decorator = StickyHeaderItemDecorator(adapter)
                    decorator.attachToRecyclerView(binding.recyclerView)
                    isStickyHeaderAttached = true
                }else if(isStickyHeaderAttached && firstVisibleItemPosition == 0){
                    binding.recyclerView.removeItemDecorationAt(0)
                    isStickyHeaderAttached = false
                }
            }
        })

         */

    }
}