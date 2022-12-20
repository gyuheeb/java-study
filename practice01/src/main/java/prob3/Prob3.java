package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int sum=0;
		while(true) {
			System.out.print("수를 입력 하세요 : ");
			int number = scanner.nextInt();
			
			if(number%2==0) {
				for(int i=0;i<=number;i+=2) {
					sum+=i;
					}
				System.out.println("결과 값"+sum);
				sum=0;
				}
			else {
					for(int j=1;j<=number;j+=2) {
						sum+=j;
						
					}
					System.out.println("결과 값"+sum);
					sum=0;
			}
				}
			}
			
		}
		
			
		
		
		