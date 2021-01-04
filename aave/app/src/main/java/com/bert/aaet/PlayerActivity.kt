package com.bert.aaet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bert.aaet.data.PlayerViewModel
import com.bert.aaet.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    /**
     * 通过ViewModelProviders获取相应的ViewModel ,让ViewModel 和 此Activity进行绑定
     */
    private val viewModel by lazy { ViewModelProviders.of(this).get(PlayerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPlayerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_player)
        /**
         * 因为LiveData是具有生命周期感知能力的被观察者，所以我们需要指定生命周期拥有者去使用。
         */
        binding.lifecycleOwner = this

        // 注意这里，将之前分散的字段都集中于ViewModel中。
        binding.viewModel = viewModel
    }
}