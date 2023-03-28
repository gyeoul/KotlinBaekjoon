import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque

/*
강의실 G5
문제
N개의 강의가 있다. 우리는 모든 강의의 시작하는 시간과 끝나는 시간을 알고 있다.
이때, 우리는 최대한 적은 수의 강의실을 사용하여 모든 강의가 이루어지게 하고 싶다.

물론, 한 강의실에서는 동시에 2개 이상의 강의를 진행할 수 없고,
한 강의의 종료시간과 다른 강의의 시작시간이 겹치는 것은 상관없다.
필요한 최소 강의실의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 강의의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에 걸쳐 각 줄마다 세 개의 정수가 주어지는데,
순서대로 강의 번호, 강의 시작 시간, 강의 종료 시간을 의미한다.
강의 번호는 1부터 N까지 붙어 있으며, 입력에서 꼭 순서대로 주어지지 않을 수 있으나 한 번씩만 주어진다.
강의 시작 시간과 강의 종료 시간은 0 이상 10억 이하의 정수이고, 시작 시간은 종료 시간보다 작다.

출력
첫째 줄에 필요한 최소 강의실 개수를 출력한다.

예제 입력 1  복사
8
6 15 21
7 20 25
1 3 8
3 2 14
8 6 27
2 7 13
4 12 18
5 6 20
예제 출력 1  복사
5

 */

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st: StringTokenizer
    val startQueue = ArrayDeque<Int>()
    val endQueue = ArrayDeque<Int>()

    var maxNum = 0
    var nowSize = 0
    val num: Int = bf.readLine().toInt()

    for (i in 1..num) {
        st = StringTokenizer(bf.readLine())
        st.nextToken()
        val start = st.nextToken()
        val end = st.nextToken()
        startQueue.add(start.toInt())
        endQueue.add(end.toInt())
    }
    startQueue.sort()
    endQueue.sort()

    while (!startQueue.isEmpty()) {
        if (endQueue.first() > startQueue.first()) {
            startQueue.removeFirst()
            nowSize++
            if (maxNum < nowSize) maxNum = nowSize
        } else {
            endQueue.removeFirst()
            nowSize--
        }
    }

    bw.write(maxNum.toString())
    bw.flush()
    bw.close()
    bf.close()
}