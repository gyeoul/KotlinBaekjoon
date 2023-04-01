package baekjoon._1000

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(bf.readLine())
    bw.write((st.nextToken().toInt() + st.nextToken().toInt()).toString())
    bw.flush()
    bw.close()
    bf.close()
}