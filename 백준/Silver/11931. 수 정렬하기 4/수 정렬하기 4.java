import java.io.*;

public class Main {
    static int N; 
    static int[] arr; 
    static int[] tmp = new int[1_000_001]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        mergeSort(0, N);
        for(int i : arr) {
            bw.write(i + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    public static void mergeSort(int st, int ed) {
        if(ed - st <= 1) {
            return; 
        }
        int mid = (st + ed) / 2; 
        mergeSort(st, mid);
        mergeSort(mid, ed);
        merge(st, ed);

    }

    public static void merge(int st, int ed) {
        int mid = (st + ed) / 2; 
        int i1 = st; 
        int i2 = mid; 

        for(int i = st; i < ed; i++) {
            if(i1 == mid) tmp[i] = arr[i2++]; 
            else if(i2 == ed) tmp[i] = arr[i1++]; 
            else if(arr[i1] > arr[i2]) tmp[i] = arr[i1++]; 
            else if(arr[i2] >= arr[i1]) tmp[i] = arr[i2++]; 
        }

        for(int i = st; i < ed; i++) {
            arr[i] = tmp[i]; 
        }
    }
}