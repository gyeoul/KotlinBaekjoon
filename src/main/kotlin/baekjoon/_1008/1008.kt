package baekjoon._1008

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    println("${st.nextToken().toInt() * 1.0 / st.nextToken().toInt()}")
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    bw.write("${st.nextToken().toInt()*1.0/st.nextToken().toInt()}")
//    bw.flush()
//    bw.close()
    bf.close()
}