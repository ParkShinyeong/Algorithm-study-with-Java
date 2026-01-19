import java.io.*;

public class Main {
    static int n ;
    static int[] arr;
    static int[] tmp = new int[1000001];
    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        
        int idx1 = st; 
        int idx2 = mid; 
        int tmpIdx = 0;

        while(idx1 < mid && idx2 < en) {
            if(arr[idx1] < arr[idx2]) tmp[tmpIdx++] = arr[idx1++]; 
            else tmp[tmpIdx++] = arr[idx2++]; 
        }

        while(idx1 < mid) {
            tmp[tmpIdx++] = arr[idx1++]; 
        }
        while(idx2 < en) {
            tmp[tmpIdx++] = arr[idx2++]; 
        }

        for(int i = st; i < en; i++) {
            arr[i] = tmp[i - st]; 
        }
        
    }

    public static void merge_sort(int st, int en) {
        if (en - st == 1) return; 
        int mid = (st + en) / 2;
        merge_sort(st, mid); 
        merge_sort(mid, en); 
        merge(st, en);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); 
        arr = new int[n]; 

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }
        
        merge_sort(0, n);
        
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}