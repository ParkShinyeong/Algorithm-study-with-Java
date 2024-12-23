# 이진트리 순회 (DFS-깊이 우선 탐색)

아래 그림과 같은 이진트리를 전위 순회, 중위 순회, 후위 순회를 연습해보자

![image](https://media.discordapp.net/attachments/955826206274641951/971330507545657364/unknown.png)

**전위 순회**

- 부모- 왼 - 오 순으로 순회
- 출력 : 1, 2, 4, 5, 3, 6, 7

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

    public void DFS(Node root) {
        if (root == null)
            return;
        else {
            System.out.println(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
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
        tree.DFS(tree.root);
    }
}

```

<br />

**중위 순회**

- 왼- 부모- 오 순으로 출력
- 4, 2, 5, 1, 6, 3, 7

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

    public void DFS(Node root) {
        if (root == null)
            return;
        else {
            DFS(root.lt);
            System.out.println(root.data + " ");
            DFS(root.rt);
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
        tree.DFS(tree.root);
    }
}

```

<br />

**후위 순회**

- 왼 - 오 - 부모 순으로 출력
- 4, 5, 2, 6, 7, 3, 1
- 병합 정렬에 사용되니까 잘 알아두자

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

    public void DFS(Node root) {
        if (root == null)
            return;
        else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.println(root.data + " ");
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
        tree.DFS(tree.root);
    }
}

```
