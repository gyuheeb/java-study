package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	//값을 표현하는걸 표현식 int i=10 리터럴..
	//private Long i = 2222222222222L; Long을 설명해주기 위해 뒤에 L붙여야함
	private float discountrate = 0.5f; //double이 아님을 알려주기 위해 f 붙여야함 
	
	public float getDiscountPrice() {
		//protected는 자식에서 접근할 수 있다. 
		return discountrate*price;
		
	}
}
