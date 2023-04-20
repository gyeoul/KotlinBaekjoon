package baekjoon._12891

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    fun checkDNA(c: Char): Int {
        when (c) {
            'A' -> return 0
            'C' -> return 1
            'G' -> return 2
            'T' -> return 3
        }
        return 0
    }

    fun checkNum(checkArray: IntArray, answerArray: IntArray): Boolean {
        return checkArray[0] >= answerArray[0] &&
                checkArray[1] >= answerArray[1] &&
                checkArray[2] >= answerArray[2] &&
                checkArray[3] >= answerArray[3]
    }

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(bf.readLine())
    val lastNum = st.nextToken().toInt()
    val size = st.nextToken().toInt()
    var ans = 0

    val dna = bf.readLine().toCharArray()
    val check = IntArray(4)
    val store = IntArray(4)
    st = StringTokenizer(bf.readLine())
    for (i in 0..3) {
        check[i] = st.nextToken().toInt()
        store[i] = 0
    }

    for (i in 0 until size) {
        store[checkDNA(dna[i])]++
    }
    if (checkNum(store, check)) ans++
    for (i in size until lastNum) {
        store[checkDNA(dna[i])]++
        store[checkDNA(dna[i - size])]--
        if (checkNum(store, check)) ans++
    }
    bw.write("$ans\n")
    bw.flush()
}