package prob01;

public class Printer {
	private int count;
	private String ans;
	private double rate;
	private String name;
	
	public Printer(int count, String ans, double rate,String name) {
		this.count =count;
		this.ans =ans;
		this.rate =rate;
		this.name =name;	
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println(count);
		System.out.println(ans);
		System.out.println(rate);
		System.out.println(name);				
	}
	
}
