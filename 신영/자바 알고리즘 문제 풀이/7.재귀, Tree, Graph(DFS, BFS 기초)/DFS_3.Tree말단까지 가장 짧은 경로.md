# Tree 말단 노드까지의 가장 짧은 경로\_BFS

아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
구하는 프로그램을 작성하세요.
각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
길이로 하겠습니다.

![image](https://cdn.discordapp.com/attachments/879215554379018243/971689753856606258/unknown.png)

가장 짧은 길이는 3번 노드까지의 길이인 1이다.

---

**코드**

```java
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;
    int dis = 0;
    static int min = Integer.MAX_VALUE;

    public void DFS(Node root) {
        if (root.lt == null && root.rt == null) {
            min = Math.min(dis, min);
        } else {
            dis++;
            DFS(root.rt);
            DFS(root.lt);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.DFS(tree.root);
        System.out.println(min);
    }
}
```

**강의 코드**

```java

import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;

    public int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null)
            return L;
        else
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.DFS(0, tree.root);
    }
}
```
