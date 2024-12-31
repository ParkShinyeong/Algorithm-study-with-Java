import java.util.Arrays;
import java.util.Scanner;

public class Main2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int[] dwarf = new int[9]; 
        int total = 0; 

        for(int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt(); 
            total += dwarf[i]; 
        }
        
        boolean status = true; 
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(total - dwarf[i] - dwarf[j] == 100) {
                    dwarf[i] = 101; 
                    dwarf[j] = 101; 
                    status = false; 
                    break; 
                }
            }
            if(!status) break; 
        }

        Arrays.sort(dwarf); 
        for(int i = 0; i < 7; i++) {
            System.out.println(dwarf[i]);
        }
    }
}
