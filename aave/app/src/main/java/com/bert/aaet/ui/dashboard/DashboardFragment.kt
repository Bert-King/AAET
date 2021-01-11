package com.bert.aaet.ui.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bert.aaet.ConstraintActivity
import com.bert.aaet.PlayerActivity
import com.bert.aaet.R
import com.bert.aaet.ui.car.CarActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn_constraint?.setOnClickListener {
            go2Constraint(it)
        }

        text_dashboard?.setOnClickListener {
           go2Player(it)
        }

        btn_room?.setOnClickListener {
            startActivity(Intent(context, CarActivity::class.java))
        }

    }

    private fun go2Player(view: View) {
        startActivity(Intent(context, PlayerActivity::class.java))
    }

    private fun go2Constraint(view: View) {
        startActivity(Intent(context, ConstraintActivity::class.java))
    }

}