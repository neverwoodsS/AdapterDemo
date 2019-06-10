package com.zll.adapter.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_test.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = object : RecyclerAdapter<String>() {
                override fun createView(parent: ViewGroup, viewType: Int): View {
                    return LayoutInflater.from(this@MainActivity).inflate(R.layout.item_test, parent, false)
                }

                override fun View.bindView(data: String, position: Int) {
                    aTestTv.text = data
                }
            }.apply {
                refreshAll(mutableListOf("1", "2", "3", "4"))
            }
        }
    }
}
