package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		System.out.print("금액 : ");
		int number = scanner.nextInt();
		
		
		int a = number/MONEYS[0];
		int b = (number % MONEYS[0])/MONEYS[1];
		System.out.println("50000원 : "+a+"개");
		System.out.println("10000원 : "+b+"개");
		int size= MONEYS.length;
		
		
		for(int i=2;i<=size+1;i++) {
			System.out.print(MONEYS[i]+"원:");
			System.out.print((number % MONEYS[i-1])/MONEYS[i]);
			System.out.println("개");
		}
		
		
		
		
		scanner.close();
 	}
}