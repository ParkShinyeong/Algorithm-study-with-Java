# 경로 탐색(인접행렬) - DFS

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

**실패 코드**

```java

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            arr[j - 1][k - 1] = 1;
        }
        boolean[] isVisit = new boolean[n];

        T.DFS(0, isVisit);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    public void DFS(int r, boolean[] isVisit) {
        isVisit[r] = true;
        for (int i = r; i < n; i++) {
            if (arr[r][i] == 1 && !isVisit[i]) {
                if (i == 4) {
                    answer++;
                } else {
                    isVisit[i] = true;
                    DFS(i, isVisit);
                    isVisit[i] = false;
                }
            }
        }
    }
}
```

**강의 코드**

```java
import java.util.*;

class Main {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n)
            answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
```

**성공 코드**

```java

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int answer = 0;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            arr[j - 1][k - 1] = 1;
        }
        isVisit = new boolean[n];
        isVisit[0] = true;

        T.DFS(0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    public void DFS(int r) {

        // -------수정한 부분------------
        for (int i = 0; i < n; i++) {
        // -------수정한 부분------------

            if (arr[r][i] == 1 && !isVisit[i]) {
                if (i == 4) {
                    answer++;
                } else {
                    isVisit[i] = true;
                    DFS(i);
                    isVisit[i] = false;
                }
            }
        }
    }
}
```
