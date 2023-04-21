package baekjoon._2164

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q = ArrayDeque<Int>()
    q.addAll(1..num)
    while (q.isNotEmpty()) {
        if (q.size == 1) {
            bw.write("${q.removeFirst()}")
            continue
        }
        q.removeFirst()
        q.add(q.removeFirst())
    }
    bw.flush()
}
