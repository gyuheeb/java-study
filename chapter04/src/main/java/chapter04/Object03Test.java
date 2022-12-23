package chapter04;

public class Object03Test {

	public static void main(String[] args) {
		String s1= new String("hello");
		String s2= new String("hello");
		
		System.out.println(s1 ==s2);        //값 비교
		System.out.println(s1.equals(s2));     //내용비교
		System.out.println(s1.hashCode()+":"+s2.hashCode());
		System.out.println(System.identityHashCode(s1)+":"+System.identityHashCode(s2));
		//다른 객체이기에 주소기반 hashcode는 다르게 나옴
		
		System.out.println("-----------------------------------------------------");
		
		String s3= "hello"+"World";
		String s4= "hello";
		//이렇게 하면 두 객체가 똑같고 new를 하면 다르다. 그래서 identityHashCode가 같다.
		
		
		
		System.out.println(s3 ==s4);        //값 비교
		System.out.println(s3.equals(s4));     //내용비교
		System.out.println(s1.hashCode()+":"+s3.hashCode());
		System.out.println(System.identityHashCode(s3)+":"+System.identityHashCode(s4));
		//다른 객체이기에 주소기반 hashcode는 다르게 나옴
		
		System.out.println("-----------------------------------------------------");
	}

}
