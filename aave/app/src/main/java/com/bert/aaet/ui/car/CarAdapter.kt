package com.bert.aaet.ui.car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bert.aaet.R
import com.bert.aaet.data.car.Car
import kotlinx.android.synthetic.main.item_car_product.view.*

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/11 5:06 PM
 * @UpdateAt: 2021/1/11 5:06 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description: 使用ListAdapter
 */
class CarAdapter:ListAdapter<Car,CarAdapter.CarViewHolder>(CarItemDiffCallback()) {

    // 1.  DiffUtil.ItemCallback
    class CarItemDiffCallback: DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }
    }

    class CarViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car_product, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        // 注意这里的getItem
        val car = getItem(position)
        holder.view.tv_title?.text = car.branch
        holder.view.tv_subtitle?.text = car.carColor
        holder.view.iv_desc.setImageResource(R.mipmap.ic_launcher_round)
    }

}