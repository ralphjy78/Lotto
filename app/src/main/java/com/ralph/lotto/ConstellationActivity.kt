package com.ralph.lotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_consstellation.*

class ConstellationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consstellation)

        Toast.makeText(applicationContext, "ConstellationActivity 입니다.", Toast.LENGTH_LONG).show()

        goResultButton.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

    }
}
