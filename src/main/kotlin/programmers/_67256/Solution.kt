package programmers._67256

import kotlin.math.abs

class Solution {
    private var leftNow = arrayOf(3, 0)
    private var rightNow = arrayOf(3, 2)
    private val answer = StringBuilder()
    fun findHand(idx: Array<Int>, hand: Boolean) {
        if (hand) {
            rightNow = idx
            answer.append("R")
        } else {
            leftNow = idx
            answer.append("L")
        }
    }

    fun solution(numbers: IntArray, hand: String): String {
        val isRight: Boolean = hand == "right"
        var idx = 0
        var now: Int
        while (idx < numbers.size) {
            now = numbers[idx]
            if (now == 0) now += 11
            when (now % 3) {
                0 -> {
                    findHand(arrayOf((now / 3) - 1, 2), true)
                }

                1 -> {
                    findHand(arrayOf(now / 3, 0), false)
                }

                2 -> {
                    if ((abs(now / 3 - rightNow[0]) + (rightNow[1] + 1) % 2) == (abs(now / 3 - leftNow[0]) + (leftNow[1] + 1) % 2)) {
                        findHand(arrayOf(now / 3, 1), isRight)
                    } else {
                        findHand(
                            arrayOf(now / 3, 1),
                            (abs(now / 3 - rightNow[0]) + (rightNow[1] + 1) % 2) < (abs(now / 3 - leftNow[0]) + (leftNow[1] + 1) % 2)
                        )
                    }
                }
            }
            idx++
        }
        return answer.toString()
    }
}