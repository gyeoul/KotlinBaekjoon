package baekjoon._1110

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val s = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    var n = s
    var c = 0
    do {
        n = (n % 10) * 10 + (n / 10 + n % 10) % 10
        c++
    } while (n != s)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("$c")
    bw.flush()
}