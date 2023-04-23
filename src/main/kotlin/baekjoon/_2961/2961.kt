package baekjoon._2961

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val maxVal = bf.readLine().toInt()
    var ans = Int.MAX_VALUE
    val arr = ArrayList<Pair<Int, Int>>()
    for (i in 1..maxVal) {
        val st = StringTokenizer(bf.readLine(), " ")
        arr.add(Pair(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    val sel = BooleanArray(maxVal)
    fun permutation(num: Int) {
        if (num == maxVal) {
            if (!sel.contains(true)) return
            var mult = 1
            var plus = 0
            for (i in sel.indices) {
                if (sel[i]) {
                    mult *= arr[i].first
                    plus += arr[i].second
                }
            }
            val ret = Math.abs(mult-plus)
            if (ret<ans)ans = ret
            return
        }
        sel[num] = true
        permutation(num + 1)

        sel[num] = false
        permutation(num + 1)
    }
    permutation(0)
    bw.write("$ans")
    bw.flush()
}