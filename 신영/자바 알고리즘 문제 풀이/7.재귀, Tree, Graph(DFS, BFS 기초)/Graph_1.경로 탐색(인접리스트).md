# 경로 탐색(인접리스트)

방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는

![image](https://cdn.discordapp.com/attachments/879215554379018243/971710582988341288/unknown.png)
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5

총 6 가지입니다.
<br />

**입력설명**
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
결정보가 주어진다.
<br />

**출력설명**
총 가지수를 출력한다.
<br />

**입력예제**

```
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
```

<br />

**출력예제**

```
6
```

<br />

---

**코드**

- 인접 행렬은 정점이 1000,,10000개 이상일 때 매우 비효율적이다. 이런 경우 인접 리스트를 사용한다.
- 인접리스트는 `ArrayList<ArrayList<Integer>>`로 구현한다.

```java

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n)
            answer++;

        else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
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

        // 인접 리스트는 ArrayList<ArrayList<Integer>> 로 구현한다.
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 정점을 방문했는지 확인하기 위해 ch를 사용
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        T.DFS(1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
```
