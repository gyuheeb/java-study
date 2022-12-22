package prob02;

public class Goods{
	
	private String bev;
	private int price;
	private int count;
	
	public String getBev() {
		return bev;
	}
	public void setBev(String bev) {
		this.bev = bev;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	void show() {
		 System.out.println(bev+"(가격:"+price+")이 "+ count +"개 입고 되었습니다.");
	}
	
	
	

}
