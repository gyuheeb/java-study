package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	void f2() {
		StaticMethod.m =10;
		//같은 클래스의 (static)class변수접근에서는 클래스 이름 생략이 가능
		m=20;
	}
	
	void f3() {
		f2();
	}
	void f4() {
		StaticMethod.s1();
		//같은 클래스의 (static)class 메소드 접근에서는 클래스 이름 생략이 가능
		s1();
	}
	static void s1() {
		//에러  :static method에서는 인스턴스 변수 접근이 불가능
		//n = 10;
	}

	static void s2() {
		//에러  :static method에서는 인스턴스 변수 접근이 불가능
		//f1();
	}
	static void s3() {
		StaticMethod.m =10;
		//같은 클래스의 (static)class변수접근에서는 클래스 이름 생략이 가능
		m=20;
	}
	static void s4() {
		StaticMethod.s1();
		//같은 클래스의 (static)class 메소드접근에서는 클래스 이름 생략이 가능
		s1();
	}
}

//인스턴스는 다 접근 가능하고  STATIC 은 같을 때

