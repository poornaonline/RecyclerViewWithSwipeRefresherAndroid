package com.poorna.recyclerviewwithswiperefresher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.poorna.recyclerviewwithswiperefresher.dao.BusinessManProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var businessMenRecyclerViewAdapter: BusinessMenRecyclerViewAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeBusinessMenRecyclerView()
        initializeSwipeRefreshLayout()
    }

    private fun initializeBusinessMenRecyclerView() {

        businessmen_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            businessMenRecyclerViewAdapter = BusinessMenRecyclerViewAdapter()
            adapter = businessMenRecyclerViewAdapter
        }

        businessMenRecyclerViewAdapter.populateBusinessMen(BusinessManProvider.getTenRandomBusinessMen())
    }

    private fun initializeSwipeRefreshLayout() {
        swipeRefreshLayout = findViewById(R.id.swipe_to_refresh)
        swipeRefreshLayout.setOnRefreshListener(this)

        swipeRefreshLayout.post(Runnable {
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.isRefreshing = true
            }
            loadData()
        })
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        swipeRefreshLayout.isRefreshing = true
        businessMenRecyclerViewAdapter.populateBusinessMen(BusinessManProvider.getTenRandomBusinessMen())
        businessmen_recycler_view.adapter = businessMenRecyclerViewAdapter
        swipeRefreshLayout.isRefreshing = false
    }
}
