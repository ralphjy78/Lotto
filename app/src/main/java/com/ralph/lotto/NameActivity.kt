package com.ralph.lotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        Toast.makeText(applicationContext, "NameActivity 입니다.", Toast.LENGTH_LONG).show()

        goButton.setOnClickListener {
            if(TextUtils.isEmpty(nameText.text.toString()))
                return@setOnClickListener

            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(nameText.text.toString())))
            intent.putExtra("name", nameText.text.toString())

            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
