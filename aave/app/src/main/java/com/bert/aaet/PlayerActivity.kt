package com.bert.aaet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bert.aaet.data.PlayerViewModel
import com.bert.aaet.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    // 通过ViewModelProviders获取相应的ViewModel
    private val viewModel by lazy { ViewModelProviders.of(this).get(PlayerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPlayerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_player)
        // 注意这里，将之前分散的字段都集中于ViewModel中。
        binding.viewModel = viewModel
    }
}