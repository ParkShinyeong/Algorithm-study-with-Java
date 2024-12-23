# 부분집합 구하기(DFS)

자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
을 작성하세요.
<br />

**입력설명**
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
<br />

**출력설명**
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
단 공집합은 출력하지 않습니다.
<br />

**입력예제**

```
3
```

<br />

**출력예제**

```
1 2 3
1 2
1 3
1
2 3
2
3
```

## <br />

**코드**

```java

import java.io.*;
public class Main {
    public String answer = "";

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            T.solution(i, "");
        }

    }

    public void solution(int n, String answer) {

        if (n < 1) {
            return;
        }

        answer = n + " " + answer;

        solution(n - 1, answer);
        System.out.println(answer);

    }
}
```

**강의 코드**

- ch라는 배열을 만든 후, 각 인덱스를 각 요소로 둔다.
- 만약 부분집합에 포함되면 1, 포함되지 않으면 0으로 표시한다.
- 재귀함수로 탐색하면서, 1 또는 0으로 바꾼다.
- 맨 마지막에 도달하면 요소가 1인 것만 포함시켜서 답을 구한다.

```java
import java.util.*;

public class Main {
    static int n;
    static int[] ch;

    public void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);

        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);

    }

}

```
