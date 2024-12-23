# Tree 말단 노드까지의 가장 짧은 경로\_BFS

아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
구하는 프로그램을 작성하세요.
각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
길이로 하겠습니다.

![image](https://cdn.discordapp.com/attachments/879215554379018243/971689753856606258/unknown.png)

가장 짧은 길이는 3번 노드까지의 길이인 1이다.

<br />

**코드**

- lt와 rt가 둘 다 null이면 바로 레벨을 리턴해준다.

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

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        int L = 0;
        Q.offer(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            Node cur = Q.poll();

            for (int i = 0; i < len; i++) {
                if (cur.rt == null && cur.lt == null) {
                    return L;
                }

                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
```
