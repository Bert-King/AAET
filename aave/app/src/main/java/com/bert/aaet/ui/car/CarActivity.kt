package com.bert.aaet.ui.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bert.aaet.R
import com.bert.aaet.ui.car.ui.carlist.CarListFragment

class CarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.car_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CarListFragment.newInstance())
                .commitNow()
        }
    }
}