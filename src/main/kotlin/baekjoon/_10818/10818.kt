package baekjoon._10818

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = IntArray(2)
    val num = bf.readLine().toInt()
    val st = StringTokenizer(bf.readLine())
//    val t = TreeSet<Int>()
//    while (st.hasMoreTokens()) {
//        t.add(st.nextToken().toInt())
//    }
//    단순 연산은 if 절이 TreeSet보다 월등히 빠름
    arr[0] = Int.MAX_VALUE
    arr[1] = Int.MIN_VALUE
    for (i in 0 until num) {
        val j = st.nextToken().toInt()
        if (arr[0] > j) arr[0] = j
        if (arr[1] < j) arr[1] = j
    }
    bw.write("${arr[0]} ${arr[1]}")
    bw.flush()
}