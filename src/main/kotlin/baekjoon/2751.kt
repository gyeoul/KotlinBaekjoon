package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
수 정렬하기 2 S4

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1  복사
5
5
4
3
2
1
예제 출력 1  복사
1
2
3
4
5
 */
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()
    val count = bf.readLine().toInt()
    val arr = ArrayList<Int>()
    /*
//    val baekjoon.getArr = IntArray(bf.readLine().toInt())
//    for (i in baekjoon.getArr.indices){
//        baekjoon.getArr[i] = bf.readLine().toInt()
//    }
     배열보다 어레이리스트가 정렬시 더 빠르다...
     */
    for (i in 1..count) {
        arr.add(bf.readLine().toInt())
    }
    arr.sort()
    for (v in arr) {
        sb.append("$v\n")
    }
    bw.write(sb.toString())
    bw.flush()
    bf.close()
    bw.close()
}