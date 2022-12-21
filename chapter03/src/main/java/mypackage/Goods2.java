package mypackage;

public class Goods2 {
	public String name;  //모든 접근이 가능하다(접근제한 없음)
	protected int price; //같은 패키지  + *자식클래스에서 접근 가능
	int countStock; // 디폴트, 같은 패키지 접근가능
	private int countSold; //클래스 내부에서 접근 가능

	public void m() {
		countSold = 50;
	}

}



