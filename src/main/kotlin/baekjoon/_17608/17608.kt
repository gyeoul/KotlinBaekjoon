package baekjoon._17608

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Int>()
    var priv = 0
    var ans = 0
    for (i in 1..bf.readLine().toInt()) {
        stack.push(bf.readLine().toInt())
    }
    while (stack.isNotEmpty()){
        val now = stack.pop()
        if (priv>=now)continue
        priv = now
        ans++
    }
    bw.write("$ans")
    bw.flush()
}