package com.ralph.lotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(applicationContext, "MainActivity 입니다.", Toast.LENGTH_LONG).show()

        randomCard.setOnClickListener {

            // 랜덤으로 생성된 6개 수를 해당 액티비티로 보냄
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()/*getRandomLottoNumybers()*/))

            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }

    }

    /**
     * Shuffle로 무작위 로또 번호 생성하기
     */
    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for(i in 1..45) {
            list.add(i)
        }

        list.shuffle()      // 리스트를 마구 섞는다

        return list.subList(0, 6).sorted().toMutableList()
    }
}
    /**
     * 랜덤으로 1~45 수를 선택하는 함수
     */
    inline fun getRandomLottoNumber(): Int {
       return Random().nextInt(45) + 1
    }

    /**
     * 랜덤으로 추출된 수를 6개 만드는 함수
     */
    fun getRandomLottoNumybers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        var randomNumber = 0

        for(i in 1..6) {
            do {
                randomNumber = getRandomLottoNumber()

            } while (lottoNumbers.contains(randomNumber))

            lottoNumbers.add(randomNumber)
        }

        return lottoNumbers
    }


