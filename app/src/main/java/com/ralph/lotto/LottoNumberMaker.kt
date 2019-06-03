package com.ralph.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    /**
     * Shuffle로 무작위 로또 번호 생성하기
     */
    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (i in 1..45) {
            list.add(i)
        }

        list.shuffle()      // 리스트를 마구 섞는다

        return list.subList(0, 6).toMutableList()
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

        for (i in 1..6) {
            do {
                randomNumber = getRandomLottoNumber()

            } while (lottoNumbers.contains(randomNumber))

            lottoNumbers.add(randomNumber)
        }

        return lottoNumbers
    }


    /**
     * 입력받은 이름으로 해시코드를 생성하고 결과를 반환함
     */
    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        val list = mutableListOf<Int>()

        for(i in 1..45) {
            list.add(i)
        }

        // 현재 날짜 추출
        val targetString = SimpleDateFormat("yyyy=MM-dd HH:mm:ss", Locale.KOREA).format(Date()) + name

        // 전달받은 이름의 해시코드를 SEED로 하여 랜덤값을 생성한다
        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6);
    }

}