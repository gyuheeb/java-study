package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point=new Point();
		
	
		//Class klass= point.getClass();    //reflection
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); //address 기반의 해싱값
											//address 값도 x 
											//refernce 값도 x
		
		System.out.println(point.toString()); //getClass()+"@"+hashCode()
		System.out.println(point);
	}

}
