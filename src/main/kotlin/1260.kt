import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque

/*
DFS와 BFS S2
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1  복사
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1  복사
1 2 4 3
1 2 3 4
예제 입력 2  복사
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2  복사
3 1 2 5 4
3 1 4 2 5
예제 입력 3  복사
1000 1 1000
999 1000
예제 출력 3  복사
1000 999
1000 999
 */
class Static() {
    companion object {
        val sb = StringBuilder()
        val queue = ArrayDeque<Int>()
        fun dfs(idx: Int) {
            if (isVisited[idx])return
            isVisited[idx]=true
            sb.append(idx).append(" ")
            arr[idx].sort()
            for(v in arr[idx]){
                dfs(v)
            }
        }

        lateinit var isVisited: BooleanArray
        val arr = ArrayList<ArrayList<Int>>()
    }
}

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(bf.readLine())
    val nodeCount: Int = st.nextToken().toInt()
    val edgeCount: Int = st.nextToken().toInt()
    val startNode: Int = st.nextToken().toInt()
    Static.isVisited = BooleanArray(nodeCount + 1)
    for (i in 0..nodeCount) {
        Static.arr.add(ArrayList())
    }
    for (i in 0 until edgeCount) {
        st = StringTokenizer(bf.readLine())
        val from: Int = st.nextToken().toInt()
        val to: Int = st.nextToken().toInt()
        Static.arr[from].add(to)
        Static.arr[to].add(from)
    }

    Static.isVisited.fill(false)
    Static.dfs(startNode)
    Static.sb.append("\n")

    Static.isVisited.fill(false)
    Static.queue.add(startNode)
    Static.isVisited[startNode]=true
    while (!Static.queue.isEmpty()){
        val idx = Static.queue.removeFirst()
        Static.sb.append(idx).append(" ")
        for (v in Static.arr[idx]){
            if (Static.isVisited[v])continue
            Static.queue.add(v)
            Static.isVisited[v] = true
        }
    }

    bw.write(Static.sb.toString())
    bw.flush()
    bw.close()
    bf.close()
}
