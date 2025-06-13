import java.io.*;
import java.util.*;

public class Main {
    static int N, minPrice; 
    static int[] nutrient; 
    static int[][] foods; 
    static ArrayList<Integer> answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        nutrient = new int[4]; 
        for(int i = 0; i < 4; i++) {
            nutrient[i] = Integer.parseInt(st.nextToken()); 
        } 
        foods = new int[N][5]; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < 5; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        int[] sumNutrient = new int[4]; 
        minPrice = Integer.MAX_VALUE; 
        recur(0, -1, new ArrayList<>(), sumNutrient, 0);

        if(minPrice == Integer.MAX_VALUE) bw.write("-1"); 
        else {
            bw.write(minPrice + "\n"); 
            for(int i: answer) {
                bw.write(i + " "); 
            } 
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int depth, int lastIdx, ArrayList<Integer> selectedFood, int[] sumNutrient, int price) {
        if(checkOverNutrient(sumNutrient)) {
            if(minPrice > price) {
                minPrice = price; 
                answer = new ArrayList<>(selectedFood); 
            }
            return; 
        }

        if(depth == N) return; 


        for(int i = lastIdx + 1; i < N; i++) {
            selectedFood.add(i + 1); 
            for(int j = 0; j < 4; j++) {
                sumNutrient[j] += foods[i][j]; 
            }
            recur(depth + 1, i, selectedFood, sumNutrient, price + foods[i][4]); 

            selectedFood.remove(selectedFood.size() - 1);   
            for(int j = 0; j < 4; j++) {
                sumNutrient[j] -= foods[i][j]; 
            }
        }
    }

    static boolean checkOverNutrient(int[] sumNutrient) {
        for(int i = 0; i < 4; i++) {
            if(nutrient[i] > sumNutrient[i]) return false; 
        }
        return true; 
    }
}
