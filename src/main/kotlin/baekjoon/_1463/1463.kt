package baekjoon._1463

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

/*
1로 만들기 S3
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1  복사
2
예제 출력 1  복사
1
예제 입력 2  복사
10
예제 출력 2  복사
3
 */
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val rawTargetValue = bf.readLine().toInt()
    val list = IntArray(rawTargetValue + 1)
    list.fill(0)
//    println(list.size)
    list[1] = 1
    for (i in 1 until rawTargetValue) {
        if (list[i] == 0) continue
//        println(i)
        for (v in intArrayOf(i + 1, i * 2, i * 3)) {
            if (v <= rawTargetValue) {
                if (list[v] != 0) list[v] = min(list[v], list[i] + 1)
                else list[v] = list[i] + 1
            }
        }
    }
    bw.write("${list[rawTargetValue] - 1}")
//    bw.write(list.contentToString())
    bf.close()
    bw.flush()
    bw.close()
}
