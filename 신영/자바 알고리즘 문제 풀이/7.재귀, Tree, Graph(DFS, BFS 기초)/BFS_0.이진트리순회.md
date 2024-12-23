# 이진트리 순회(넓이우선탐색 : 레벨탐색)

아래 그림과 같은 이진트리를 레벨탐색 연습하세요.

![image](https://cdn.discordapp.com/attachments/955826206274641951/971330507545657364/unknown.png)

- BFS는 최단 거리를 탐색할 때 쓰인다.

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

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.println(level + ": " + cur.data + " ");
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
```

**출력값**
level : element

```
0: 1
1: 2
1: 3
2: 4
2: 5
2: 6
2: 7
```
