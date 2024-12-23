# 8. 송아지 찾기 1(BFS : 상태트리탐색)

**설명**

현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.

현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.

송아지는 움직이지 않고 제자리에 있다.

현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.

최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

**입력**
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

**출력**
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

**예시 입력 1**

```
5 14
```

**예시 출력 1**

```
3
```

---

**코드**

```java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(T.BFS(s, e)));
        bw.flush();
        bw.close();

    }

    public int BFS(int s, int e) {
        // 방문했는지 안했는지 확인
        boolean[] isVisit = new boolean[10001];
        isVisit[s] = true;

        Queue<Integer> dist = new LinkedList<>();
        dist.offer(s);

        int lev = 0;

        while (!isVisit[e]) {
            int len = dist.size();
            for (int i = 0; i < len; i++) {
                int cur = dist.poll();

                if (cur == e)
                    break;

                int ch1 = cur - 1;
                int ch2 = cur + 1;
                int ch3 = cur + 5;

                if (ch1 > 0 && ch1 < 10001 && !isVisit[ch1]) {
                    dist.offer(ch1);
                    isVisit[ch1] = true;
                }
                if (ch2 > 0 && ch2 < 10001 && !isVisit[ch2]) {
                    dist.offer(ch2);
                    isVisit[ch2] = true;
                }
                if (ch3 > 0 && ch3 < 10001 && !isVisit[ch3]) {
                    dist.offer(ch3);
                    isVisit[ch3] = true;
                }
            }
            lev++;
        }
        return lev;
    }
}
```

**강의 코드**

- 최소의 횟수로 갈 수 있는 거리를 구해라 => 최단 거리 알고리즘

```java
import java.util.*;

public class Main {
    int answer = 0;
    int[] dis = { 1, -1, 5 };
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();

                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        if (nx == e) {
                            // 여기서 바로 리턴하면 된다. ㅠㅜㅠ
                            return L + 1;
                        }
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
```
