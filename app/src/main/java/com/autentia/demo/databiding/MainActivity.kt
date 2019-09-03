package com.autentia.demo.databiding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.autentia.demo.databiding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainActivityViewModel =
            ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.activityViewModel = mainActivityViewModel
        binding.lifecycleOwner = this

        posts_recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CustomRecyclerViewAdapter(mutableListOf())
        }

        press_me_button.setOnClickListener {
            mainActivityViewModel.loadPosts()
        }
    }
}
