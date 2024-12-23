# 그래프 최단거리(BFS)

다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.

**입력설명**
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
결정보가 주어진다.
<br />

**출력설명**
1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
<br />

**입력예제**

```
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
```

**출력예제**

```
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
```

---

**코드**

- level을 사용해 풀이

```java

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, lv = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static HashMap<Integer, Integer> answer = new HashMap<>();
    static Queue<Integer> Q;

    public void BFS(int v) {
        Q.add(1);
        while (!Q.isEmpty()) {
            lv++;
            for (int i = 0; i < Q.size(); i++) {
                int a = Q.poll();
                for (int x : graph.get(a)) {
                    if (!answer.containsKey(x) && x != 1) {
                        Q.offer(x);
                        answer.put(x, lv);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            graph.get(a).add(b);
        }

        Q = new LinkedList<>();
        T.BFS(1);

        for (int i = 2; i <= n; i++) {
            bw.write(i + " : " + answer.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
```

**강의 코드**

- dis 배열을 사용해 풀이
- 방문하지 않은 정점이면 이전 정점 레벨 + 1한 값을 dis 배열에 넣어준다.

```java
import java.util.*;

class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int cv = queue.poll(); // current vertex
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
```
