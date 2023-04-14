package programmers._42586

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val ans = ArrayList<Int>()
        var days = 1
        var count = 0
        for(i in progresses.indices){
            while((speeds[i]*days)+progresses[i]<100)days++
            count++
            if(i+1<progresses.size&&(speeds[i+1]*days)+progresses[i+1]>=100)continue
            ans.add(count)
            count=0
        }
        return ans.toIntArray()
    }
}