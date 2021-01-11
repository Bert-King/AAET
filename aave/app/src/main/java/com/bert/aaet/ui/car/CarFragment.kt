package com.bert.aaet.ui.car

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bert.aaet.R
import kotlinx.android.synthetic.main.car_fragment.*

class CarFragment : Fragment() {

    companion object {
        fun newInstance() = CarFragment()
    }

    private lateinit var viewModel: CarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)

        val carAdapter = CarAdapter()
        rv_car?.adapter = carAdapter
        rv_car?.setHasFixedSize(true)
        // 注意这里: 使用ListAdapter，这里要使用submitList()
        carAdapter.submitList(viewModel.cars.value)

    }

}