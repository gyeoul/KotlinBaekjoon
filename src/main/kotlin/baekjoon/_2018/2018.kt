package baekjoon._2018

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    var ans = 0
    for (i in 1..num) {
        var sum = 0
        for (j in i downTo 1) {
            sum += j
            if (sum == num) ans++
            if (sum > num) break
        }
    }
    val bf = BufferedWriter(OutputStreamWriter(System.out))
    bf.write("$ans\n")
    bf.flush()
}