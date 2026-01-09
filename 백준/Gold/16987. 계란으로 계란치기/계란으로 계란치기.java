import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static Egg[] eggs; 
    static int answer = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        N = Integer.parseInt(br.readLine()); 

        eggs = new Egg[N]; 
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
        }
        brokenEgg(0, 0); 
        bw.write(answer + "");
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void brokenEgg(int idx, int brokenEggCnt) {
        if(idx == N) {
            answer = Math.max(answer, brokenEggCnt); 
            return; 
        }

        if(eggs[idx].durability <= 0) {
            brokenEgg(idx + 1, brokenEggCnt); 
            return; 
        }

        Egg tmp = eggs[idx]; 
        int tmpDurability = tmp.durability; 
        boolean isBrokenEggs = false; 

        for(int i = 0; i < N; i++) {
            if(eggs[i].durability <= 0 || i == idx) continue; 

            Egg nxt = eggs[i];
            int nxtDurability = nxt.durability; 
            int be = 0;
            if(tmp.durability - nxt.weight <= 0) {
                be++; 
            }
            if(nxt.durability - tmp.weight <= 0) {
                be++; 
            }

            tmp.durability -= nxt.weight; 
            nxt.durability -= tmp.weight; 
            isBrokenEggs = true; 

            brokenEgg(idx + 1, brokenEggCnt + be); 

            tmp.durability = tmpDurability; 
            nxt.durability = nxtDurability; 
        }

        if(!isBrokenEggs) brokenEgg(idx + 1, brokenEggCnt); 
    }
}

class Egg {
    int durability; 
    int weight; 

    Egg(int durability, int weight) {
        this.durability = durability; 
        this.weight = weight; 
    }
}