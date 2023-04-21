package baekjoon._1158

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val q = ArrayDeque<Int>()
    val st = StringTokenizer(BufferedReader(InputStreamReader(System.`in`)).readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    q.addAll(1..st.nextToken().toInt())
    val k = st.nextToken().toInt()

    bw.write("<")
    while (q.isNotEmpty()){
        for (i in 1 until  k){
            q.add(q.removeFirst())
        }
        bw.write("${q.removeFirst()}")
        if (q.isNotEmpty())bw.write(", ")
    }
    bw.write(">")
    bw.flush()
}