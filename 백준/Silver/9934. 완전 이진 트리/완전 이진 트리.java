import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int nodeCnt = (int)(Math.pow(2, N) - 1);
        arr = new int[nodeCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < nodeCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer>[] tree = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        circuitTree(0, nodeCnt - 1, tree);
        for(int i = 0; i < N; i++) {
            for(int num: tree[i]) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void circuitTree(int lt, int rt, ArrayList<Integer>[] tree) throws IOException {
        int lv = 0;
        Queue<int[]> nodes = new ArrayDeque<>();
        nodes.offer(new int[] {lt, rt, lv});
        while(!nodes.isEmpty()) {
            int[] tmp = nodes.poll();
            int tmplt = tmp[0];
            int tmprt = tmp[1];
            int tmplv = tmp[2];
            int mid = (tmplt + tmprt) / 2;
            tree[tmplv].add(arr[mid]);

            if(tmplt == tmprt) continue;

            nodes.offer(new int[] {tmplt, mid - 1, tmplv + 1});
            nodes.offer(new int[] {mid + 1, tmprt, tmplv + 1});
        }
    }
}
