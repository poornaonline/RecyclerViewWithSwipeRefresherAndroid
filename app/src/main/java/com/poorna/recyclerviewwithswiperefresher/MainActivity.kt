package com.poorna.recyclerviewwithswiperefresher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.poorna.recyclerviewwithswiperefresher.dao.BusinessManProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var businessMenRecyclerViewAdapter: BusinessMenRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeBusinessMenRecyclerView()
    }

    private fun initializeBusinessMenRecyclerView() {

        businessmen_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            businessMenRecyclerViewAdapter = BusinessMenRecyclerViewAdapter()
            adapter = businessMenRecyclerViewAdapter
        }

        businessMenRecyclerViewAdapter.populateBusinessMen(BusinessManProvider.getTenRandomBusinessMen())
    }
}
