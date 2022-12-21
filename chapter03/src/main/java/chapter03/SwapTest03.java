package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a= new Value(10);
		Value b= new Value(20);
		
		
		System.out.println("a:"+ a.Val +",b:"+b.Val );
		
		swap(a,b);
		
		System.out.println("a:"+ a.Val +",b:"+b.Val );
	}
	
	public static void swap(Value m, Value n) {
		int i=m.Val;
		m.Val =n.Val ;
		n.Val =i ;
	} //static은 지역변수로 m,n연산(callbyValue)후 계산 끝나고 사라짐 stack에는 a와b만 남아서 값이 변화안함.

}
