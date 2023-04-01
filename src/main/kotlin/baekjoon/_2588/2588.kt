package baekjoon._2588

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = bf.readLine().toInt()
    val a = bf.readLine().toCharArray()
    var sum = 0.0
    for (i in 2 downTo 0) {
        val x = (a[i] - '0') * t
        bw.write("$x\n")
        sum += x * 10.0.pow(2 - i)
    }
//    println(Arrays.toString(arr))
    bw.write("${sum.toInt()}")
    bw.flush()
}