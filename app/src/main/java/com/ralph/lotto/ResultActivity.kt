package com.ralph.lotto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        Toast.makeText(applicationContext, "ResultActivity 입니다.", Toast.LENGTH_LONG).show()

        // 앞 화면에서 전달받은 랜덤 숫자 6개를 인텐트로부터 꺼내온다
        val result = intent.getIntegerArrayListExtra("result")

        result?.let {
            //updateLottoBallImage(ArrayList(result.sorted()))
            updateLottoBallImage(ArrayList(result))
        }
    }

    // 로또 1번 공 이미지
    val lottoImageStartId = R.drawable.ball_01

    fun updateLottoBallImage(result: ArrayList<Int>) {
        if(result.size < 6) return

        imageView1.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView2.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView3.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView4.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView5.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView6.setImageResource(lottoImageStartId + (result[5] - 1))
    }
}
