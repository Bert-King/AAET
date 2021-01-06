package com.bert.aaet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun go2Player(view: View) {
        startActivity(Intent(this,PlayerActivity::class.java))
    }

    fun go2Constraint(view: View) {
        startActivity(Intent(this,ConstraintActivity::class.java))
    }
}