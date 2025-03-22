import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); 
		int B = sc.nextInt(); 
		int C = sc.nextInt(); 
		int D = sc.nextInt(); 
		
		C += D; 
		B += C / 60; 
		A += B / 60; 
		
		A %= 24; 
		B %= 60; 
		C %= 60; 
		
		System.out.println(A + " " + B + " " + C);
	}
}
