package prob3;

public interface Soundable {
	public String sound();
		
     
     
}//AbstractTest

abstract class Cat{ // 추상 메서드를 포함하므로 추상클래스로 선언
 abstract void call(); // 추상 메서드 선언(구현x)
 void call2(){
     System.out.println("일반 메서드");
}
