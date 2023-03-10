package chapter03;

public class Goods {
	public static int countOfGoods =0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		countOfGoods = Goods.countOfGoods +1; //'Good.' 내부 같은 클래스라 생략 가능하다
	}
	
	public Goods(String name, int price, int countStock, int countsold) {
			this.name =name;
			this.price= price;
			this.countStock =countStock;
			this.countSold =countSold;
	}
	public int calcDiscountPrice(float discountRate){
		int i = (int)4.5;
		
		return (int)(price * discountRate); //int형인걸 미리 암시
	}
	
	public void printlnfo() {
		System.out.println(name + ": " +price+" : " + countStock +" : "+ countSold );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if( price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	
	
}
