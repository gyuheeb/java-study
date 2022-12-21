package chapter03;

public class SwapTest022 {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		System.out.println("a:"+ a+",b:"+b);
		
		swap(a,b);
		
		System.out.println("a:"+ a+",b:"+b);
	}
	
	public static void swap(int m, int n) {
		int i=m;
		m=n;
		n=m;
	} //static은 지역변수로 m,n연산(callbyValue)후 계산 끝나고 사라짐 stack에는 a와b만 남아서 값이 변화안함.

}
