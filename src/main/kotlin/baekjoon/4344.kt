package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
평균은 넘겠지 B1

문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

예제 입력 1  복사
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
예제 출력 1  복사
40.000%
57.143%
33.333%
66.667%
55.556%
 */
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val rawInputDataNum: Int = bf.readLine().toInt()
    val resultArray = FloatArray(rawInputDataNum)
    for (i in 0 until rawInputDataNum) {
        val st = StringTokenizer(bf.readLine())
        val oneLineDataCount = st.nextToken().toInt()
        var sum = 0
        val nums = IntArray(oneLineDataCount)
        var eliteStudent = 0
        for (j in 0 until oneLineDataCount) {
            val k = st.nextToken().toInt()
            sum += k
            nums[j] = k
        }
        for (v in nums) {
            if (v > (sum).toFloat() / oneLineDataCount) eliteStudent++
        }
        resultArray[i] = (eliteStudent).toFloat() / oneLineDataCount * 100
    }
//    println(resultArray.contentToString())
    for (v in resultArray) {
        println(String.format("%.3f", v) + "%")
    }
}