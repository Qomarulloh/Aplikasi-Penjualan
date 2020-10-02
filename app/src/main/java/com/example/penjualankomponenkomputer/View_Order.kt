package com.example.penjualankomponenkomputer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.penjualankomponenkomputer.MainActivity.Companion.dbHandler

class View_Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view__order)

        viewOrder()
    }

    private fun viewOrder(){
        val vieworderlist = dbHandler.getAllOrder(this)
        val adapter = View_Adapter(this, vieworderlist)
        val rv: RecyclerView = findViewById(R.id.rv_view)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = adapter
    }
}